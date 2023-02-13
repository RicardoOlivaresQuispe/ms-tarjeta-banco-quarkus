package org.nttdata.bootcamp.quarkus.tarjeta.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tarjeta")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tarjeta {

    @Id
    @GeneratedValue
    @Column(name = "id_tarjeta")
    private Long idTarjeta;
    @Column(name = "numero_tarjeta")
    private String numTarjeta;
    @Column(name = "pin_tarjeta")
    private Long pinTarjeta;
    @Column(name = "tipo_tarjeta")
    private String tipTarjeta;
    @Column(name = "fecha_vencimiento")
    private LocalDate fecVenc;
    @Column(name = "codigo_validacion")
    private Long codValTarj;
    @Column(name = "fecha_corte")
    private LocalDate fecCorte;
    @Column(name = "fecha_limite_pago_mensual")
    private LocalDate fecLimPagMens;
    @Column(name = "saldo_actual")
    private BigDecimal salActu;
    @Column(name = "limite_credito")
    private BigDecimal limCred;
    @Column(name = "cuenta_bancaria")
    private String cuentBanc;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "numero_documento_cliente")
    private String numDocCli;
    @Column(name = "estado")
    private String estado;

    public Tarjeta() {
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Long getPinTarjeta() {
        return pinTarjeta;
    }

    public void setPinTarjeta(Long pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    public String getTipTarjeta() {
        return tipTarjeta;
    }

    public void setTipTarjeta(String tipTarjeta) {
        this.tipTarjeta = tipTarjeta;
    }

    public LocalDate getFecVenc() {
        return fecVenc;
    }

    public void setFecVenc(LocalDate fecVenc) {
        this.fecVenc = fecVenc;
    }

    public Long getCodValTarj() {
        return codValTarj;
    }

    public void setCodValTarj(Long codValTarj) {
        this.codValTarj = codValTarj;
    }

    public LocalDate getFecCorte() {
        return fecCorte;
    }

    public void setFecCorte(LocalDate fecCorte) {
        this.fecCorte = fecCorte;
    }

    public LocalDate getFecLimPagMens() {
        return fecLimPagMens;
    }

    public void setFecLimPagMens(LocalDate fecLimPagMens) {
        this.fecLimPagMens = fecLimPagMens;
    }

    public BigDecimal getSalActu() {
        return salActu;
    }

    public void setSalActu(BigDecimal salActu) {
        this.salActu = salActu;
    }

    public BigDecimal getLimCred() {
        return limCred;
    }

    public void setLimCred(BigDecimal limCred) {
        this.limCred = limCred;
    }

    public String getCuentBanc() {
        return cuentBanc;
    }

    public void setCuentBanc(String cuentBanc) {
        this.cuentBanc = cuentBanc;
    }


    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumDocCli() {
        return numDocCli;
    }

    public void setNumDocCli(String numDocCli) {
        this.numDocCli = numDocCli;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
