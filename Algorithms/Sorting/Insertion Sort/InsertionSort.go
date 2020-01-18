import "fmt"

func main() {
     data := []int{1, 5, 4, 8, 12, 2, 1, 2, 7, 9}
     fmt.Println("Before:", data)
     fmt.Println("After:", sort(data))
}


func sort(data []int) []int{
   for i :=0; i< len(data); i++{
      for j:=0; j< i + 1; j++{
        if data[j] > data[i]{
            temp := data[j]
            data[j] = data[i]
            data[i] = temp
        }
      }
   }
   return data
}