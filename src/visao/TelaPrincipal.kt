package visao

import modelo.Tabuleiro
import modelo.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

fun main(args: Array<String>) {
    TelaPrincipal()
}

class TelaPrincipal : JFrame(){

    private val tabuleiro = Tabuleiro(qtdeLinhas = 16, qtdeColunas = 30, qtdeMinas = 10)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)


    init {
        tabuleiro.onEvento(this::mostrarResultado)
        add(painelTabuleiro)

        setSize(690,438)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        title = "Campo Minado by Leo"
        isVisible = true
    }

    private fun mostrarResultado(evento: TabuleiroEvento){
        SwingUtilities.invokeLater {
            val msg = when(evento){
                TabuleiroEvento.VITORIA -> "Parabéns! Você Ganhou!"
                TabuleiroEvento.DERROTA -> "Tenha fé em Deus, Tenha fé na vida! Tente outra vez!"
            }

            JOptionPane.showMessageDialog(this,msg)
            tabuleiro.reinicializar()
            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}