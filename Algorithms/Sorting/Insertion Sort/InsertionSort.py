def insertionSort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i-1
        while j >= 0 and key < arr[j] :
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr


arr = [1, 5, 4, 8, 12, 2, 1, 2, 7, 9]
print(f"Before: {arr}")
print(f"After: {insertionSort(arr)}")
