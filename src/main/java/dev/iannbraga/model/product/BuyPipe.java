package dev.iannbraga.model.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import lombok.Data;

@Entity
@Data
@Table(name = "buy_pipe")
public class BuyPipe extends DefaultEntity{
    
    @ManyToOne
    @JoinColumn(name = "pipe_id")
    private PipeEntity pipe;

    @ManyToOne
    @JoinColumn(name = "buy_id")
    private BuyEntity buy;

    private int amount;
}