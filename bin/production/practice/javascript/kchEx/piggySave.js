function piggySave(){
    let total = 0;
    return function add(money){
        total += money
        console.log(total)
    }
}
const p1 = piggySave();
p1(100)
const p2 = piggySave();
p2(200)