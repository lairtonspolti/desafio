package models

import java.math.BigDecimal

open class Item(
    var codigo:Long,
    var cdBarras: String?,
    var descricao:String,
    var qtd: Int,
    var vlrProduto: BigDecimal,
    val vlrDesconto: BigDecimal= BigDecimal.ZERO,
    val vlrAcrescimo: BigDecimal= BigDecimal.ZERO
) {
    val totalItem: BigDecimal get() =  vlrProduto.multiply(qtd.toBigDecimal()).add(vlrAcrescimo).minus(vlrDesconto)
}