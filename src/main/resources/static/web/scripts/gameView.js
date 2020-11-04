var app = new Vue({
    el: "#board",
    data: {
        columns: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"],
        rows: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"],
        gameview: null,
        viewer : null,
        opponent : null,
    },
    methods: {
        drawShips : function(){
            for (var i = 0 ; i < app.gameview.ships.length ; i++){
                for (var z = 0 ; z < app.gameview.ships[i].locations.length ; z++){
                    document.getElementById(app.gameview.ships[i].locations[z]).classList.add('ship');
                }
            }
        },

        drawSalvoes: function(){
            for(i=0 ; i< app.gameview.salvoes.length ; i++){
                for(z=0 ; z < app.gameview.salvoes[i].locations.length; z++){
                    if (app.gameview.salvoes[i].playerId == app.viewer.id){
                        document.getElementById(app.gameview.salvoes[i].locations[z] + "1").classList.add('salvo');

                    }else{
                        for (var j = 0 ; j < app.gameview.ships.length ; j++){
                            for (var x = 0 ; x < app.gameview.ships[j].locations.length ; x++){
                                if(app.gameview.salvoes[i].locations[z] == app.gameview.ships[j].locations[x]){
                                    document.getElementById(app.gameview.salvoes[i].locations[z]).classList.add('shot');
                                }
                            }
                        }
                    }
                }
            }
        },

        gameInfo: function(){
            for (var i = 0 ; i <app.gameview.gamePlayers.length ; i++){
                if (app.gameview.gamePlayers[i].id == gp){
                    app.viewer = app.gameview.gamePlayers[i].player;
                }else{
                    app.opponent = app.gameview.gamePlayers[i].player;
                }
            }
        }
        
    }
})

var urlParams = new URLSearchParams(window.location.search);
var gp = urlParams.get('gp');

var api = "/api/game_view/" + gp;

fetch(api)
  .then(response => response.json())
  .then(function(object){
      app.gameview = object;
      console.log(object);
      app.drawShips();
      app.gameInfo();
      app.drawSalvoes();
  }).catch(function(error){
      console.log(error);
  });