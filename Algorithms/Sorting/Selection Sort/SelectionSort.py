A = [1, 5, 4, 8, 12, 2, 1, 2, 7, 9]

def selectionSort(array):
    for i in range(len(array)):
        min = i
        for j in range(i + 1, len(array)):
            if array[min] > array[j]:
                min = j
        temp = array[min]
        array[min] = array[i]
        array[i] = temp
    return array

print(f"Before: {A}")
print(f"After: {selectionSort(A)}")