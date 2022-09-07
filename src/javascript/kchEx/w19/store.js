const storeService = (function(){

    const urlArr = ['http://localhost:8080/w19/1team.json','http://localhost:8080/w19/2team.json','http://localhost:8080/w19/3team.json']

    let storeArr = []

    function loadJson(index, callback){

        $.getJSON(urlArr[index], function(data){
            storeArr = data
            callback(data)
        })

    }

    function getStore(sno){
        return storeArr.filter(s => s.sno === sno)[0]
    }

    return {loadJson, getStore}

})()