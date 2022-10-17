function outer() {
    let arr = []
    let idx = 0

    function add(todo){
        todo.idx = idx++ 
        arr.push(todo)
    }
    function removeTodo(num){
        console.log("remove Todo...")

        const result = arr.filter(todo => todo.idx !== num)

        arr = result;
    }
    function getTodo(idx){
        console.log("getTodo")
    }
    function getAll(){
        return arr
    }  
    function changeAll(){
        for (let i = 0; i < arr.length; i++) {
            arr[i].complete = !arr[i].complete 
        }
    }
    console.log(arr)
    const obj = {add,removeTodo,getTodo,getAll,changeAll}
    
    return obj
}
const arr =[
    {name:'F1', gender:'F'},
    {name:'M1', gender:'M'},
    {name:'F1', gender:'F'},
    {name:'M1', gender:'M'},
    {name:'M1', gender:'M'}
]

const result = arr.filter(obj => obj.gender === 'M')

console.log(result)