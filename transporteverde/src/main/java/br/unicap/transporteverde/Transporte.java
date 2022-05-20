package br.unicap.transporteverde;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public class Transporte {
    
    private final long id;
    private final String nomeEmpresaRemetente;
    private final String nomeEmpresaDestinatario;

    

    public Transporte(long id, String nomeEmpresaRemetente, String nomeEmpresaDestinatario) {
        this.id = id;
        this.nomeEmpresaRemetente = nomeEmpresaRemetente;
        this.nomeEmpresaDestinatario = nomeEmpresaDestinatario;
    }


    public long getId() {
        return id;
    }
    public String getNomeEmpresaRemetente() {
        return nomeEmpresaRemetente;
    }
    public String getNomeEmpresaDestinatario() {
        return nomeEmpresaDestinatario;
    }

    public static Transporte formJSONString(String json, Long sid){
        long id = sid;
        String nomeEmpresaRemetente = new JSONObject(json).getString("nomeEmpresaRemetente");
        String nomeEmpresaDestinatario = new JSONObject(json).getString("nomeEmpresaDestinatario");
        Transporte asset = new Transporte(id, nomeEmpresaRemetente, nomeEmpresaDestinatario);
        return asset;
    }
}
