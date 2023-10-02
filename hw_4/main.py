import math

def calculate_mean(numbers):
    return sum(numbers) / len(numbers)

def calculate_standard_deviation(numbers):
    mean = calculate_mean(numbers)
    variance = sum((x - mean) ** 2 for x in numbers) / len(numbers)
    return math.sqrt(variance)

def calculate_covariance(x, y):
    mean_x = calculate_mean(x)
    mean_y = calculate_mean(y)
    covariance = sum((x[i] - mean_x) * (y[i] - mean_y) for i in range(len(x))) / len(x)
    return covariance

def pearson_correlation(x, y):
    covariance = calculate_covariance(x, y)
    standard_deviation_x = calculate_standard_deviation(x)
    standard_deviation_y = calculate_standard_deviation(y)
    correlation = covariance / (standard_deviation_x * standard_deviation_y)
    return correlation

x = [5, 5, 6]
y = [7, 6, 9]

correlation = pearson_correlation(x, y)
print(correlation)

