from rest_framework import routers
from .views import AprazamentoVacinasViewset, ProfissionalViewSet, VacinaViewSet, ProfissionalSaudeEUSFViewset, HistoricoDeVacinasViewset, UnidadeSaudeFamiliarViewset, CuidadorViewset, CuidadorCriancaViewset, CriancaViewset, CrescimentoCriancaViewset, AgendamentoViewSet, LogradouroViewSet, EnderecoViewSet, ConsultaViewSet

router = routers.DefaultRouter()

router.register(r'aprazamento', AprazamentoVacinasViewset)
router.register(r'profissional', ProfissionalViewSet)
router.register(r'vacina', VacinaViewSet)
router.register(r'profissionalEUSF', ProfissionalSaudeEUSFViewset)
router.register(r'unidadesaudefamiliar', UnidadeSaudeFamiliarViewset)
router.register(r'historico', HistoricoDeVacinasViewset)
router.register(r'cuidador', CuidadorViewset)
router.register(r'CuidadorCrianca', CuidadorCriancaViewset)
router.register(r'Crianca', CriancaViewset)
router.register(r'crescimentoCrianca', CrescimentoCriancaViewset)
router.register(r'agendamento', AgendamentoViewSet)
router.register(r'logradouro', LogradouroViewSet)
router.register(r'endereco', EnderecoViewSet)
router.register(r'consulta', ConsultaViewSet)
urlpatterns = router.urls