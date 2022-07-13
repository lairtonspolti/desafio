import models.Carrinho
import models.Cliente
import models.FormaPagamento
import models.Item
import java.math.BigDecimal
import java.time.LocalDate

fun main(){
    var carrinho =  Carrinho()
    carrinho.cliente = Cliente(1,"Joao da Silva", LocalDate.now(), "02641789043")

    var item1 = Item(88,
            "789100150150",
        "Aerolin GSK",
        2,
        BigDecimal(100), vlrDesconto = BigDecimal(20)
    )

    carrinho.itens.add(item1)

    var item2 = Item(928,
        "789100150150",
        "Sabonete Dove",
        2,
        BigDecimal(3), vlrDesconto = BigDecimal(0.50), vlrAcrescimo = BigDecimal(0.10)
    )
    carrinho.itens.add(item2)

    carrinho.formaPagamento= FormaPagamento(1,"Dinheiro")

    //carrinho.retornaResumoCarrinho()
    println(carrinho.retornaResumoCarrinho())
}