package models

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDateTime

class Carrinho (
    val id: Long=0L,
    var cliente: Cliente? = null,
    val data: LocalDateTime = LocalDateTime.now(),
    var formaPagamento: FormaPagamento?= null,
    var vlrProduto: BigDecimal= BigDecimal.ZERO,

    var itens: ArrayList<Item> = arrayListOf()
    )
{
    val vlrAcrescimo: BigDecimal get() = itens.sumOf { item -> item.vlrAcrescimo }
    val vlrDesconto: BigDecimal get() = itens.sumOf { item -> item.vlrDesconto }
    val totalCarrinho: BigDecimal get() = itens.sumOf { item -> item.totalItem }

    fun percentualEconomizado(): String{
        val perc = this.vlrDesconto.multiply(BigDecimal(100)).divide(this.totalCarrinho.add(this.vlrDesconto), RoundingMode.HALF_UP)
        return  "${perc}%"
    }

    fun formataReais(vlr: BigDecimal): String{
        return "R$ ${vlr.setScale(2, RoundingMode.HALF_UP)}"
    }

    //    Baseado nas informações criar uma função que receba os parâmetros e calcule o total do
    //    carrinho caso possuir desconto, mostre o objeto populado e uma mensagem de retorno amigável
    //    com total do carrinho e se obtiver desconto > 0 colocar junto na mesma quanto que o cliente
    //    economizou em $$ e também em %.
    fun retornaResumoCarrinho(): StringBuilder {
        val texto = StringBuilder()

        texto.appendLine("Ola ${cliente?.nome}")
        texto.appendLine("Itens da compra")

        itens.forEach{item ->

            texto.appendLine("----------------------------------------")
            texto.appendLine("${item.codigo} - ${item.descricao} qtd  ${item.qtd} itens,  total -> ${formataReais(item.totalItem)}")
        }
        texto.appendLine("----------------------------------------")

        texto.appendLine("Total da sua compra ${formataReais(this.totalCarrinho)}")
        texto.appendLine("Forma de pagamento: ${this.formaPagamento?.nome}")

        if(!this.vlrDesconto.equals(BigDecimal.ZERO))
            texto.appendLine("Voce economizou ${formataReais(this.vlrDesconto)}, um total de  ${this.percentualEconomizado()} de economia!")

        return texto
    }

}