package br.unicap.transporteverde;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.hyperledger.example.HFJavaSDKBasicExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/transporte")
@Api(value = "Transporte")
@CrossOrigin(origins = "*")
public class TransporteController {
    
    private final AtomicLong cunter = new AtomicLong();

    
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna Transporte")
    public Transporte getTransporte(@PathVariable Long id){
        String transporte = "";

        try{
            transporte = HFJavaSDKBasicExample.getTransporte(id);
        }catch(Exception e){};
        Transporte newTransporte = Transporte.formJSONString(transporte, id);
        return newTransporte;
    }
}
