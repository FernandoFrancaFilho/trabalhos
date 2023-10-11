from rest_framework import viewsets
from .models import AprazamentoVacinas, Profissional, Vacina, ProfissionalSaudeEUSF, UnidadeSaudeFamiliar, HistoricoDeVacinas, Cuidador, CuidadorCrianca, Crianca, CrescimentoCrianca, Agendamento, Logradouro, Endereco, Consulta
from .serializers import AprazamentoVacinasSerializer, ProfissionalSerializer, VacinaSerializer, ProfissionalSaudeEUSFSerializer, UnidadeSaudeFamiliarSerializer, HistoricoDeVacinasSerializer, CuidadorSerializer, CuidadorCriancaSerializer, CriancaSerializer, CrescimentoCriancaSerializer, AgendamentoSerializer, LogradouroSerializer, EnderecoSerializer, ConsultaSerializer

class ProfissionalViewSet(viewsets.ModelViewSet):
    queryset = Profissional.objects.all()
    serializer_class = ProfissionalSerializer

class VacinaViewSet(viewsets.ModelViewSet):
    queryset = Vacina.objects.all()
    serializer_class = VacinaSerializer

class AprazamentoVacinasViewset(viewsets.ModelViewSet):
    queryset = AprazamentoVacinas.objects.all()
    serializer_class = AprazamentoVacinasSerializer

class ProfissionalSaudeEUSFViewset(viewsets.ModelViewSet):
    queryset = ProfissionalSaudeEUSF.objects.all()
    serializer_class = ProfissionalSaudeEUSFSerializer

class UnidadeSaudeFamiliarViewset(viewsets.ModelViewSet):
    queryset = UnidadeSaudeFamiliar.objects.all()
    serializer_class = UnidadeSaudeFamiliarSerializer

class HistoricoDeVacinasViewset(viewsets.ModelViewSet):
    queryset = HistoricoDeVacinas.objects.all()
    serializer_class = HistoricoDeVacinasSerializer

class CuidadorViewset(viewsets.ModelViewSet):
    queryset = Cuidador.objects.all()
    serializer_class = CuidadorSerializer

class CuidadorCriancaViewset(viewsets.ModelViewSet):
    queryset = CuidadorCrianca.objects.all()
    serializer_class = CuidadorCriancaSerializer

class CriancaViewset(viewsets.ModelViewSet):
    queryset = Crianca.objects.all()
    serializer_class = CriancaSerializer

class CrescimentoCriancaViewset(viewsets.ModelViewSet):
    queryset = CrescimentoCrianca.objects.all()
    serializer_class = CrescimentoCriancaSerializer

class AgendamentoViewSet(viewsets.ModelViewSet):
    queryset = Agendamento.objects.all()
    serializer_class = AgendamentoSerializer

class LogradouroViewSet(viewsets.ModelViewSet):
    queryset = Logradouro.objects.all()
    serializer_class = LogradouroSerializer

class EnderecoViewSet(viewsets.ModelViewSet):
    queryset = Endereco.objects.all()
    serializer_class = EnderecoSerializer

class ConsultaViewSet(viewsets.ModelViewSet):
    queryset = Consulta.objects.all()
    serializer_class = ConsultaSerializer