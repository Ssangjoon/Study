const arr = [4,3,23,52,11,235,222]

arr.sort((a,b) => a-b)

arr.sort((a,b) => {
    console.log(a)
    console.log(b)
    console.log(a-b)
    console.log("-------------")
    return a-b
})

console.log(arr)