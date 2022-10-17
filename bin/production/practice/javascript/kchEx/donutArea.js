// 주어진 데이터 
const r1 = 10; 
const r2 = 20; 

// 원의 넓이 
const c1 = Math.pow(r1,2) * Math.PI
const c2 = Math.pow(r2,2) * Math.PI
 
let gap = c1 - c2

// if 삼항 연산자
// if (gap < 0){
//     gap = gap* -1
// }

gap = gap < 0 ? gap* -1 : gap 
gap = gap.toFixed(2)

console.log("이 도형의 넓이는 " + gap + "입니다.")
console.log(`이 도형의 넓이는 ${gap} 입니다. `)