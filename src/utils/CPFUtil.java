package utils;

public class CPFUtil {

    public static boolean isValid(String cpf) {

        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        if (cpf == null || cpf.trim().isEmpty() || Long.valueOf(cpf.trim()).equals(Long.valueOf("0")) ||
                cpf.trim().equals("00000000000") || cpf.trim().equals("11111111111") ||
                cpf.trim().equals("22222222222") || cpf.trim().equals("33333333333") ||
                cpf.trim().equals("44444444444") || cpf.trim().equals("55555555555") ||
                cpf.trim().equals("66666666666") || cpf.trim().equals("77777777777") ||
                cpf.trim().equals("88888888888") || cpf.trim().equals("99999999999"))
            return false;

        if (cpf.trim().length() != 11) {
            return false;
        } else {

            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;

            for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
                digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();
                //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                d1 = d1 + (11 - nCount) * digitoCPF;
                //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                d2 = d2 + (12 - nCount) * digitoCPF;
            }

            //Primeiro resto da divisão por 11.
            resto = (d1 % 11);
            digito1 = (resto < 2 ? 0 : (11 - resto));
            d2 += 2 * digito1;

            //Segundo resto da divisão por 11.
            resto = (d2 % 11);
            digito2 = (resto < 2 ? 0 : (11 - resto));

            //Digito verificador do CPF que está sendo validado.
            String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());
            //Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
            //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
            return nDigVerific.equals(nDigResult);
        }
    }

    public static String format(String cpf) {

        if (cpf == null) {
            return "";
        }

        cpf = cpf.replaceAll("[\\.\\-_/ ]", "");

        if (cpf.length() != 11) {
            return "";
        }

        StringBuilder sb = new StringBuilder(cpf).insert(3, ".").insert(7, ".").insert(11, "-");

        return sb.toString();

    }

    public static String unformat(String cpf) {

        if (cpf == null) {
            return "";
        }

        cpf = cpf.replaceAll("[\\.\\-_/ ]", "");

        return cpf;

    }

}