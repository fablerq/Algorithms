def binarySearch(arr, low, high, x):
    while low <= high:
        mid = low + (high - low)//2
        if x < arr[mid]:
            high = mid - 1
        elif x > arr[mid]:
            low = mid + 1
        else:
            return mid
    return -1


arr = [1, 5, 4, 8, 12, 2, 3, 22, 7, 9]
print(f"After: {binarySearch(arr, 0, len(arr) - 1, 2)}")