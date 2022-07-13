package models

import utils.CPFUtil
import java.time.LocalDate;

class Cliente(
    var id: Long,
    val nome: String,
    val dtNascimento:LocalDate,
    var cpf: String
){
    fun formataCpf(): String{
        return CPFUtil.format(cpf)
    }

    fun cpfValido():Boolean{
        return CPFUtil.isValid(cpf)
    }
}
