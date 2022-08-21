const arr = []
while (true) {

    // 숫자를 생성 1 - 45 사이의 숫자 
    const num = parseInt(Math.random()*45) + 1; 
    console.log(num)
    
    // 검사 
    const index = arr.indexOf(num)

    if(index >= 0){
        continue
    }
    const newLength = arr.push(num)
    if(newLength === 6) {
        break
    }
}

console.log(arr)

const arrNum = []
for (let i = 0; i < 45; i++){
    arrNum.push(i+1)
}

for(let i = 0; i < 6; i++){
const idx = parseInt(Math.random() * arrNum.length +1 ) //arr.length = 45
console.log(arrNum.splice(idx,1))
}
