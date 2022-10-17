// 분기별 매출현황
const arr = [
    {month:1, total:90}, {month:2, total:87}, {month:3, total:140},
    {month:4, total:120}, {month:5, total:11110}, {month:6, total:150},
    {month:7, total:180}, {month:8, total:240}, {month:9, total:200},
    {month:10, total:180}, {month:11, total:140}, {month:12, total:190}
]

arr.sort((a,b) => a.total-b.total)


// 최고 매출 월을 도출 해보자 
const maxMonth = arr[arr.length-1]
console.log(`최고 매출 월은 ${maxMonth.month} 입니다`)
