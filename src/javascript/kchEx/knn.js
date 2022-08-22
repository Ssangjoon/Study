const movies = [
    {action:12, kiss:2, cate: 'A'}, // 암살
    {action:2, kiss:14, cate: 'M'}, // 어바웃타ㅣㅁ
    {action:7, kiss:2, cate: 'A'}, // 토이스토리 
    {action:6, kiss:15, cate: 'M'} // 타이타닉
]

const target = {action:9, kiss:3} //반지의 제왕

movies.sort((a,b) => {

    const disA = Math.sqrt(Math.pow(a.action-target.action, 2) + Math.pow(a.kiss-target.kiss, 2))
    const disB = Math.sqrt(Math.pow(b.action-target.action, 2) + Math.pow(b.kiss-target.kiss, 2))

    return disA - disB > 0 ? 1: -1
})
console.log(movies)