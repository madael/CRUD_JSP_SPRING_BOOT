package com.proj.planejador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proj.planejador.pipe.RiscoPipe;
import com.proj.planejador.pipe.StatusPipe;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "data_inicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;
    @Column(name = "data_previsao_fim")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPrevisaoFim;
    @Column(name = "data_fim")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFim;
    @Lob
    private String descricao;
    private String status;
    private Double orcamento;
    private String risco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idgerente", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Pessoa gerente;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "membros",
            joinColumns = {@JoinColumn(name = "idpessoa")},
            inverseJoinColumns = {@JoinColumn(name = "idprojeto", foreignKey = @ForeignKey(name = "fk_membros_pessoa"))})
    private List<Pessoa> membros;

    public Projeto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(Date dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusTaduzido() {
        return StatusPipe.transform(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getRisco() {
        return risco;
    }

    public String getRiscoTaduzido() {
        return RiscoPipe.transform(risco);
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public void setGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

    public List<Pessoa> getMembros() {
        return membros;
    }

    public void setMembros(List<Pessoa> membros) {
        this.membros = membros;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataPrevisaoFim=" + dataPrevisaoFim +
                ", dataFim=" + dataFim +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", orcamento='" + orcamento + '\'' +
                ", risco='" + risco + '\'' +
                ", gerenteId=" + gerente.getId() +
                '}';
    }

}
