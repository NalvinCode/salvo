var app = new Vue({
    el: '#games',
    data : {
        games : null,

        usersStatics: [],
    },
    methods: {

      getPlayerStatics: function(){
        let users = this.getUsers();
        let userScore = this.getUserScore(users);
        let userWins = this.getUserWins(users);
        let userTies = this.getUserTies(users);
        let userLosses = this.getUserLosses(users);

        for(let i = 0 ; i < users.length ; i++){
          let userObject = { "user":"null", "total":null, "wins":null, "ties":null, "losses":null};
          userObject.user = users[i];
          userObject.total = userScore[i];
          userObject.wins = userWins[i];
          userObject.ties = userTies[i];
          userObject.losses = userLosses[i];

          app.usersStatics.push(userObject);
        }
      },

      getUsers: function(){
        var users = [];
        for(let i = 0; i < app.games.length; i++){
          for (let z = 0; z < app.games[i].gamePlayers.length ; z++){
            if (!users.includes(app.games[i].gamePlayers[z].player.user)){
              users.push(app.games[i].gamePlayers[z].player.user);
            }
          }
        }
        return users;
      },

      /*getUsers: function(){
        var players = [];
        for(let i = 0; i < app.games.length; i++){
          for (let z = 0; z < app.games[i].gamePlayers.length ; z++){
            
            players.push(app.games[i].gamePlayers[z].player.user);
          }
        }
        var users = [];
        
        players.forEach((u) => {
          if (!users.includes(u)) {
              users.push(u);
          }
        })

        return users;
      },*/

      getUserScore: function(users){
        var scores = [];
        for (let i = 0; i < users.length ; i++){
          scores.push(0);
          for(let z = 0; z < app.games.length; z++){
            for(let j = 0; j < app.games[z].gamePlayers.length; j++){
              if (app.games[z].gamePlayers[j].player.user == users[i]){
                if(app.games[z].gamePlayers[j].score == null){
                  scores[i] += 0;

                }else{
                  scores[i] += app.games[z].gamePlayers[j].score;
                }
              }
            }
          }
        }
        return scores;
      },

      getUserWins : function(users){
        var wins = [];
        for (let i = 0; i < users.length ; i++){
          wins.push(0);
          for(let z = 0; z < app.games.length; z++){
            for(let j = 0; j < app.games[z].gamePlayers.length; j++){
              if (app.games[z].gamePlayers[j].player.user == users[i]){
                if (app.games[z].gamePlayers[j].score == 1){
                  wins[i]++;
                }
              }
            }
          }
        }
        return wins;
      },

      getUserTies : function(users){
        var ties = [];
        for (let i = 0; i < users.length ; i++){
          ties.push(0);
          for(let z = 0; z < app.games.length; z++){
            for(let j = 0; j < app.games[z].gamePlayers.length; j++){
              if (app.games[z].gamePlayers[j].player.user == users[i]){
                if (app.games[z].gamePlayers[j].score == 0.5){
                  ties[i]++;
                }
              }
            }
          }
        }
        return ties;
      },

      getUserLosses : function(users){
        var losses = [];
        for (let i = 0; i < users.length ; i++){
          losses.push(0)
          for(let z = 0; z < app.games.length; z++){
            for(let j = 0; j < app.games[z].gamePlayers.length; j++){
              if (app.games[z].gamePlayers[j].player.user == users[i]){
                if (app.games[z].gamePlayers[j].score == 0){
                  losses[i]++;
                }
              }
            }
          }
        }
        return losses;
      }
    },



    filters: {
        formatDate: function (value) {
          if (!value){ 
            return ''
          }
          return moment(value).format('DD/MM/YYYY, h:mm:ss A');
        }
      },
});

fetch('http://localhost:8080/api/games')
  .then(response => response.json())
  .then(function(object){
      app.games = object;
      app.getPlayerStatics(app.games);
      console.log(object)
  }).catch(function(error){
      console.log(error)
  });
