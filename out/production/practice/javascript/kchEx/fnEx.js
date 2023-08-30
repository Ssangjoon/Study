function calc(a,b,fn){
    const result = fn(a+1,b+1)
    return result
}
console.log(calc(10,20,(x,y)=>x +y)) // 32
console.log(calc(10,20,(x,y)=>x -y)) // -10  