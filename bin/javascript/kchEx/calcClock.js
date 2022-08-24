
function calcTotal(hourValue, minValue){
    // 시침의 각도 구하는 함수 
    function calcHour(hour) {
        const result = (360/12) * (hour % 12)
    
        return result
    }
    // 분침 각도 함수
    const calcMin = min => (360/60) * min
    // 분침에 시침의 이동 각도를 구하는 함수 
    function getExtra(min){
        
        return ((360/12) / 60) * min
    }
    const result = Math.abs( (calcHour(hourValue) + getExtra(minValue)) - calcMin(minValue))
    return result > 180 ? 360 - result : result
}
console.log(calcTotal(12,38))