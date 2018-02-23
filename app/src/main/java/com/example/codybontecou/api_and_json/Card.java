package com.example.codybontecou.api_and_json;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by codybontecou on 2/22/18.
 */

public class Card extends RealmObject implements Serializable {


    private String cardId;
    private String dbfId;
    private String name;
    private String cardSet;
    private String type;
    private String faction;
    private String rarity;
    private String cost;
    private String attack;
    private String health;
    private String text;
    private String flavor;
    private String artist;
    private String collectible;
    private String elite;
    private String playerClass;
    private String img;
    private String imgGold;
    private String locale;
    private String mechanics;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getDbfId() {
        return dbfId;
    }

    public void setDbfId(String dbfId) {
        this.dbfId = dbfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardSet() {
        return cardSet;
    }

    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCollectible() {
        return collectible;
    }

    public void setCollectible(String collectible) {
        this.collectible = collectible;
    }

    public String getElite() {
        return elite;
    }

    public void setElite(String elite) {
        this.elite = elite;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgGold() {
        return imgGold;
    }

    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMechanics() {
        return mechanics;
    }

    public void setMechanics(String mechanics) {
        this.mechanics = mechanics;
    }

    //    [
//    {
//        "cardId": "EX1_116",
//            "dbfId": "559",
//            "name": "Leeroy Jenkins",
//            "cardSet": "Classic",
//            "type": "Minion",
//            "faction": "Alliance",
//            "rarity": "Legendary",
//            "cost": 5,
//            "attack": 6,
//            "health": 2,
//            "text": "<b>Charge</b>. <b>Battlecry:</b> Summon two 1/1 Whelps for your opponent.",
//            "flavor": "At least he has Angry Chicken.",
//            "artist": "Gabe from Penny Arcade",
//            "collectible": true,
//            "elite": true,
//            "playerClass": "Neutral",
//            "img": "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_116.png",
//            "imgGold": "http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_116_premium.gif",
//            "locale": "enUS",
//            "mechanics": [
//        {
//            "name": "Charge"
//        },
//        {
//            "name": "Battlecry"
//        }
//        ]
//    }
}
