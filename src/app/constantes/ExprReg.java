package app.constantes;


/**
 * enum que contiene toda las regulares expresiones
 * para prueba de expresiones regulares https://regex101.com
 * @author theph
 *
 */
public enum ExprReg {
	/**
     * Expresion regular de numeros ROMANO
     * https://stackoverflow.com/a/39200728
     */
	REG_EXP_NUMERO_ROMANO("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"),
	REG_EXP_PREGUNTA("^(how)\\s((many Credits)|(much is)).*\\?$"),
	REG_EXP_CREDITS("[a-zA-Z].*(is)\\s+(\\d+)\\s+(Credits)"),
	REG_EXP_NO_CREDITS("[a-zA-Z].*(is)\\s+((I)|(V)|(X)|(L)|(C)|(D)|(M))$"),
	REG_EXP_REPLACE_NO_CREDITS("\\b( is )\\b"),
	REG_EXP_REPLACE_IS_CREDITS("(\\bis\\b)|(\\bCredits\\b)"),
	REG_EXP_PREG_BUSCA_FRASE("(\\bhow \\b)|(\\bmany\\b|\\bmuch\\b)|(\\bis\\b)|(\\b Credits is \\b)|(\\?)$");
	
	private String regExp;

	ExprReg(String regExp) {
		this.regExp = regExp;
	}

	public String getRegExp() {
		return this.regExp;
	}
}
