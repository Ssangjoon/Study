const readline = require('readline-sync');
// 1ft 3.5s
// 300 * 200
console.log("1피트당 샷시의 가격은 얼마입니까")
const perFeet = parseFloat(readline.prompt()); 
// 숫자 외에 값이 들어오는 것을 방지 하기 위해 무조건 소수점 처리를 하는 코드 추가 

console.log("가로길이는 얼마인가요? cm")
const width = parseInt(readline.prompt()) ;

console.log("가로길이는 얼마인가요? cm")
const height = parseInt(readline.prompt()) ;

// 창문 =>  가로 * 2, 세로 * 2 => 전체 샷시 길이 

const totalLength = (width * 2) +  (height * 2) 

// 길이(cm) => ft 
const totalFeet = Math.ceil(totalLength / 30.48)

// 가격 계산 
const totalPay = totalFeet * perFeet

console.log(`총 ${totalPay} 입니다`)

