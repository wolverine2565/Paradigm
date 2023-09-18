def sortNumberImperative(numbers):
    n = len(numbers)
    for i in range(n):
        for j in range(i+1, n):
            if numbers[j] > numbers[i]:
                temp = numbers[i]
                numbers[i] = numbers[j]
                numbers[j] = temp

    return numbers


def sortNumbersDeclarative(numbers):
    sorted_numbers = sorted(numbers, reverse=True)
    return sorted_numbers





