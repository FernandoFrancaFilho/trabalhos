import com.calopsita.despesas.dtos.CadastrarDespesaDto;
import com.calopsita.despesas.dtos.DespesaDtoResponse;
import com.calopsita.despesas.models.DespesaModel;
import com.calopsita.despesas.repositories.DespesasRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CadastrarDespesaServiceImplTest {

    @MockBean
    private DespesasRepository despesasRepositoryMock;

    @InjectMocks
    private CadastrarDespesaServiceImpl cadastrarDespesaService;

    @Test
    public void testCadastrar() {
        CadastrarDespesaDto cadastrarDespesaDto = new CadastrarDespesaDto(
                "Teste Despesa",
                "Alimentação",
                50.0
        );

        when(despesasRepositoryMock.save(Mockito.any(DespesaModel.class))).thenAnswer(invocation -> {
            DespesaModel despesaModel = invocation.getArgument(0);
            return new DespesaModel(
                    1,
                    despesaModel.getDescricao(),
                    despesaModel.getCategoria(),
                    despesaModel.getValor(),
                    LocalDateTime.now()
            );
        });

        DespesaDtoResponse despesaDtoResponse = cadastrarDespesaService.cadastrar(cadastrarDespesaDto);

        assertEquals(1, despesaDtoResponse.getId());
        assertEquals(cadastrarDespesaDto.getDescricao(), despesaDtoResponse.getDescricao());
        assertEquals(cadastrarDespesaDto.getCategoria(), despesaDtoResponse.getCategoria());
        assertEquals(cadastrarDespesaDto.getValor(), despesaDtoResponse.getValor());
    }

    @Test
    public void testRemoverGastoExistente() {
        // Dados de exemplo
        int gastoId = 1;

        // Simula a existência do gasto no repositório
        DespesaModel despesaExistente = new DespesaModel(gastoId, "Teste Despesa", "Alimentação", 50.0, LocalDateTime.now());
        when(despesasRepositoryMock.findById(gastoId)).thenReturn(Optional.of(despesaExistente));

        // Simula a remoção do gasto
        cadastrarDespesaService.removerGasto(gastoId);

        // Verifica se o método de remoção foi chamado com o ID correto
        verify(despesasRepositoryMock).deleteById(gastoId);
    }

    @Test
    public void testVisualizarTodasDespesas() {
        // Dados de exemplo
        DespesaModel despesa1 = new DespesaModel(1, "Despesa 1", "Categoria 1", 100.0, LocalDateTime.now());
        DespesaModel despesa2 = new DespesaModel(2, "Despesa 2", "Categoria 2", 150.0, LocalDateTime.now());
        List<DespesaModel> despesas = Arrays.asList(despesa1, despesa2);

        // Simula a obtenção de todas as despesas do repositório
        when(despesasRepositoryMock.findAll()).thenReturn(despesas);

        // Chama o método do serviço para obter todas as despesas
        List<DespesaDtoResponse> despesasResponse = cadastrarDespesaService.visualizarTodasDespesas();

        // Verifica se o método do serviço retorna a lista correta
        assertEquals(despesas.size(), despesasResponse.size());
        assertEquals(despesa1.getId(), despesasResponse.get(0).getId());
        assertEquals(despesa1.getDescricao(), despesasResponse.get(0).getDescricao());
        assertEquals(despesa1.getCategoria(), despesasResponse.get(0).getCategoria());
        assertEquals(despesa1.getValor(), despesasResponse.get(0).getValor());

        assertEquals(despesa2.getId(), despesasResponse.get(1).getId());
        assertEquals(despesa2.getDescricao(), despesasResponse.get(1).getDescricao());
        assertEquals(despesa2.getCategoria(), despesasResponse.get(1).getCategoria());
        assertEquals(despesa2.getValor(), despesasResponse.get(1).getValor());
    }
}


    @Test
    public void testFiltrarGastosMensais() {
        // Dados de exemplo
        LocalDateTime now = LocalDateTime.now();
        DespesaModel despesa1 = new DespesaModel(1, "Despesa 1", "Categoria 1", 100.0, now);
        DespesaModel despesa2 = new DespesaModel(2, "Despesa 2", "Categoria 2", 150.0, now.minusMonths(1));
        List<DespesaModel> despesas = Arrays.asList(despesa1, despesa2);

        // Simula a obtenção de todas as despesas do repositório
        when(despesasRepositoryMock.findAll()).thenReturn(despesas);

        // Chama o método do serviço para obter os gastos mensais
        List<DespesaDtoResponse> despesasMensais = cadastrarDespesaService.filtrarGastosMensais();

        // Verifica se o método do serviço retorna a lista correta
        assertEquals(1, despesasMensais.size());
        assertEquals(despesa1.getId(), despesasMensais.get(0).getId());
        assertEquals(despesa1.getDescricao(), despesasMensais.get(0).getDescricao());
        assertEquals(despesa1.getCategoria(), despesasMensais.get(0).getCategoria());
        assertEquals(despesa1.getValor(), despesasMensais.get(0).getValor());
    }

    @Test
    public void testFiltrarGastosPorCategoria() {
        // Dados de exemplo
        DespesaModel despesa1 = new DespesaModel(1, "Despesa 1", "Categoria 1", 100.0, LocalDateTime.now());
        DespesaModel despesa2 = new DespesaModel(2, "Despesa 2", "Categoria 2", 150.0, LocalDateTime.now());
        List<DespesaModel> despesas = Arrays.asList(despesa1, despesa2);

        // Simula a obtenção de todas as despesas por categoria do repositório
        when(despesasRepositoryMock.findByCategoria("Categoria 1")).thenReturn(Arrays.asList(despesa1));

        // Chama o método do serviço para obter os gastos por categoria
        List<DespesaDtoResponse> despesasPorCategoria = cadastrarDespesaService.filtrarGastosPorCategoria("Categoria 1");

        // Verifica se o método do serviço retorna a lista correta
        assertEquals(1, despesasPorCategoria.size());
        assertEquals(despesa1.getId(), despesasPorCategoria.get(0).getId());
        assertEquals(despesa1.getDescricao(), despesasPorCategoria.get(0).getDescricao());
        assertEquals(despesa1.getCategoria(), despesasPorCategoria.get(0).getCategoria());
        assertEquals(despesa1.getValor(), despesasPorCategoria.get(0).getValor());
    }
}