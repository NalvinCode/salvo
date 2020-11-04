package com.codeoftheweb.demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Salvo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Integer turn;

    @ElementCollection
    @Column(name="location")
    private List<String> locations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gamePlayer_id")
    private GamePlayer gamePlayer;

    public Salvo() { }

    public Salvo(Integer turn, List<String> locations, GamePlayer gamePlayer){
        this.turn = turn;
        this.locations = locations;
        this.gamePlayer = gamePlayer;
    }

    public Integer getTurn() {
        return turn;
    }

    public List<String> getLocations() {
        return locations;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public Map<String, Object> salvoToDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("playerId", this.gamePlayer.getPlayer().getId());
        dto.put("turn", this.turn);
        dto.put("locations", this.locations);
        return dto;
    }

}
