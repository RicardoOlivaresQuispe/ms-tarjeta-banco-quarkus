package org.nttdata.bootcamp.quarkus.tarjeta.ws.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TarjetaVO {

    private String numeroTarjeta;
    private String pinTarjeta;
    private String tipoTarjeta;
    private LocalDate fechaVencimiento;
    private Long codigoValidacion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate fechaCorte;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate fechaLimitePagoMens;
    private BigDecimal saldoActual;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal limiteCredito;
    private String cuentaBancaria;
    private String cliente;
    private String numeroDocumento;

    public TarjetaVO() {
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(Long codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public LocalDate getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(LocalDate fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public LocalDate getFechaLimitePagoMens() {
        return fechaLimitePagoMens;
    }

    public void setFechaLimitePagoMens(LocalDate fechaLimitePagoMens) {
        this.fechaLimitePagoMens = fechaLimitePagoMens;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public void setPinTarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
