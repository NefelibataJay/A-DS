def min_lexicographical_order(n, arr):
    # 将每个整数转换为字符串
    arr = list(map(str, arr))

    # 自定义排序：若a+b的字典序小于b+a，则a排在b前面
    arr.sort(key=lambda x: x*10)  # 使用x*10扩展是为了处理数字长度不同的情况

    # 输出重新排列后的结果
    print(" ".join(arr))


# 输入示例
n = 3  # 输入整数n
arr = [2, 1, 21]  # 输入n个整数的数组

# 调用函数输出结果
min_lexicographical_order(n, arr)
