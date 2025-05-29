from openai import OpenAI
import argparse
# 设置你的 DeepSeek API Key
# api_key = 'sk-3f3a5a60468645feb79655491c956096'
# base_url = 'https://api.deepseek.com/v1'
client = OpenAI(
    api_key="sk-3f3a5a60468645feb79655491c956096",
    base_url="https://api.deepseek.com/v1"
)

def prompt_merge(prompt_init,data):
    if not re.search(r"\{[^{}]+\}", prompt_init):
        return prompt_init
    else:
        if "{scripts}" in prompt_init:
            prompt_init=prompt_init.replace("{scripts}", data["scripts"])
        if "{truth}" in prompt_init:
            prompt_init=prompt_init.replace("{truth}", data["truth"])
        if "{answer}" in data:
            if "{question}" in prompt_init:
                prompt_init = prompt_init.replace("{question}", data["question"])
        if "{referenceAnswer}" in prompt_init:
            prompt_init=prompt_init.replace("{referenceAnswer}", data["referenceAnswer"])
        if "{characterName}" in prompt_init:
            prompt_init=prompt_init.replace("{characterName}", data["characterName"])

    return prompt_init

def chat_with_llm(prompt,text,style, temperature, model):  # deepseek-reasoner   （r1）
    """
    使用 DeepSeek 模型与输入文本进行对话。
    参数:
        text (str): 用户输入的提示文本
        model (str): 使用的模型名称，默认是 "deepseek-chat"
        temperature (float): 控制输出的多样性，范围为 [0.0, 1.0]
    返回:
        str: 模型返回的回复
    """
    # 根据风格调整温度
    if temperature is None:
        if style == "理智冷静":
            temperature = 0.3
        elif style == "情绪真实":
            temperature = 0.7
        elif style == "疯癫怪异":
            temperature = 0.9
        else:
            temperature = 0.7  # 默认值

    if model == "deepseekv3":
        model = "deepseek-chat"
    else:
        model = "deepseek-reasoner"

    try:
        response = client.chat.completions.create(
            model=model,
            messages=[
                {"role": "system", "content": prompt},
                {"role": "user", "content": text}
            ],
            temperature=temperature,
            stream=False
        )
        return response.choices[0].message.content.strip()

    except Exception as e:
        return f"服务器繁忙，请重新输入进行对话。错误信息: {str(e)}"

app = Flask(__name__)


@app.route("/chat", methods=["POST"])
def chat():
    try:
        data = request.json
        prompt = data.get("prompt", "")
        characterName=data.get("characterName", "")
        scripts=data.get("scripts", "")
        truth=data.get("truth", "")
        question=data.get("question", "")
        referenceAnswer=data.get("referenceAnswer", "")
        answer=data.get("answer", "")

        style = data.get("style", "情绪真实")
        model = data.get("model", "deepseekv3")
        temperature = data.get("temperature", None)

        # 根据id获取prompt
        if prompt in ["1", "2", "3", 1, 2, 3]:
            prompt_file_path = f"prompt_{prompt}.md"
            if os.path.exists(prompt_file_path):
                with open(prompt_file_path, "r", encoding="utf-8") as f:
                    if prompt_file_path.endswith(".json"):
                        prompt_data = json.load(f)
                        prompt_init = prompt_data.get("prompt", "")
                    else:
                        prompt_init = f.read()
            else:
                return jsonify({"error": f"未找到文件: {prompt_file_path}"}), 400

        # 参数插入到 prompt_init 里面
        prompt = prompt_merge(prompt_init, data)

        # 用户输入的问题
        text = answer if answer else question

        # return jsonify({"prompt": prompt, "text":text})

        # print("prompt:", prompt)
        # print("text:", text)

        # 请求LLM响应
        reply = chat_with_llm(prompt, text, style, temperature, model)
        print(reply)
        return jsonify({"reply": reply})

    except Exception as e:
        return jsonify({"error": str(e)}), 500


if __name__ == "__main__":
    app.run(host="124.220.94.212", port=8849)
    # app.run(host="127.0.0.1", port=5000)
