from openai import OpenAI
import argparse
# 设置你的 DeepSeek API Key
# api_key = 'sk-3f3a5a60468645feb79655491c956096'
# base_url = 'https://api.deepseek.com/v1'
client = OpenAI(
    api_key="sk-3f3a5a60468645feb79655491c956096",
    base_url="https://api.deepseek.com/v1"
)
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

# 示例用法
if __name__ == "__main__":

    parser = argparse.ArgumentParser(description="与LLM对话")
    parser.add_argument('--prompt', default="你是一个侦探助手。", help="任务prompt（默认：你是一个侦探助手。）")
    parser.add_argument('--text', required=True, help="输入提示语（必填）")
    parser.add_argument('--style', default="情绪真实", help="对话风格（默认：情绪真实）")
    parser.add_argument('--temperature', type=float, default=None, help="采样温度越小越保守，优先级高于style")
    parser.add_argument('--model', choices=["deepseekv3", "deepseekr1"], default="deepseekv3",
                        help="选择模型（默认：deepseekv3）")
    parser.add_argument('--speaker', default="AI助手:", help="回答的对象（默认：AI助手）")
    args = parser.parse_args()

    reply = chat_with_llm(args.prompt,args.text,args.style,args.temperature,args.model)
    print("{}: {}".format(args.speaker, reply))
