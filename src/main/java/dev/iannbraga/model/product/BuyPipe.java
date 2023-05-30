package dev.iannbraga.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
