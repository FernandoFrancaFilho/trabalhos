from rest_framework import serializers
from .models import AprazamentoVacinas, Profissional, Vacina, ProfissionalSaudeEUSF, UnidadeSaudeFamiliar, HistoricoDeVacinas, Cuidador, CuidadorCrianca, Crianca, CrescimentoCrianca, Agendamento, Logradouro, Endereco, Consulta

class ProfissionalSerializer(serializers.ModelSerializer):
    class Meta:
        model = Profissional
        fields = '__all__'

class VacinaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Vacina
        fields = '__all__'

class AprazamentoVacinasSerializer(serializers.ModelSerializer):
    class Meta:
        model = AprazamentoVacinas
        fields = '__all__'

class ProfissionalSaudeEUSFSerializer(serializers.ModelSerializer):
    class Meta:
        model = ProfissionalSaudeEUSF
        fields = '__all__'

class HistoricoDeVacinasSerializer(serializers.ModelSerializer):
    class Meta:
        model = HistoricoDeVacinas
        fields = '__all__'

class UnidadeSaudeFamiliarSerializer(serializers.ModelSerializer):
    class Meta:
        model = UnidadeSaudeFamiliar
        fields = '__all__'

class HistoricoDeVacinasSerializer(serializers.ModelSerializer):
    class Meta:
        model = HistoricoDeVacinas
        fields = '__all__'

class CuidadorSerializer(serializers.ModelSerializer):
    class Meta:
        model = Cuidador
        fields = '__all__'

class CuidadorCriancaSerializer(serializers.ModelSerializer):
    class Meta:
        model = CuidadorCrianca
        fields = '__all__'

class CriancaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Crianca
        fields = '__all__'

class CrescimentoCriancaSerializer(serializers.ModelSerializer):
    class Meta:
        model = CrescimentoCrianca
        fields = '__all__'

class AgendamentoSerializer(serializers.ModelSerializer):
    class Meta:
        model = Agendamento
        fields = '__all__'

class LogradouroSerializer(serializers.ModelSerializer):
    class Meta:
        model = Logradouro
        fields = '__all__'

class EnderecoSerializer(serializers.ModelSerializer):
    class Meta:
        model = Endereco
        fields = '__all__'

class ConsultaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Consulta
        fields = '__all__'