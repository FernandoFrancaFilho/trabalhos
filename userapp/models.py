from django.db import models

# Entidade Profissional de Saude

class Profissional(models.Model):
    id_profissional_saude = models.CharField(max_length=150) #Tornar Id autoincrement
    nome = models.CharField(max_length=150)
    cpf = models.CharField(max_length=14, unique=True)
    email = models.CharField(max_length=150)
    senha = models.CharField(max_length=150)
    telefone = models.CharField(max_length=11, unique=True)
    tipo_profissional = models.CharField(max_length=150)
    conselho = models.CharField(max_length=150)

    def __str__(self):
        return self.nome

# Vacina

class Vacina(models.Model):
    id_vacina = models.AutoField(primary_key=True)
    tipo_vacina = models.CharField(max_length=150)
    profissional = models.ForeignKey(Profissional, related_name='vacinas', on_delete=models.CASCADE)
    data_vacina = models.DateField()
    lote = models.CharField(max_length=150)
    fabricante = models.CharField(max_length=150)
    data_fabricacao = models.DateField()
    id_agendamento = models.DateTimeField()

    def __str__(self):
        return str(self.id_agendamento)

    def __str__(self):
        return self.tipo_vacina
    
# AprazamentoVacinas

class AprazamentoVacinas(models.Model):
    id_vacina = models.ForeignKey(Vacina, on_delete=models.CASCADE, related_name='aprazamento_vacinas')
    id_agendamento = models.ForeignKey(Vacina, on_delete=models.CASCADE, related_name='aprazamento_agendamentos')
    criado_em_dia_mes_ano = models.DateField()

    def __str__(self):
        return f'Vacina: {self.id_vacina.id_vacina}, Agendamento: {self.id_agendamento.id_agendamento}'

# ProfissionalSaudeEUSF

class ProfissionalSaudeEUSF(models.Model):
    idUSF = models.CharField(max_length=150)
    idProfissional = models.CharField(max_length=150)
    criado_em_dia_mes_ano = models.DateField()

# Unidade Saude Familiar

class UnidadeSaudeFamiliar(models.Model):
    idUSF = models.CharField(max_length=150)
    idCuidador = models.CharField(max_length=150)
    idCrianca = models.CharField(max_length=150)
    idProfissional = models.CharField(max_length=150)
    idEndereco = models.CharField(max_length=150)
    criado_em_dia_mes_ano = models.DateField()


# Historico de Vacinas

class HistoricoDeVacinas(models.Model):
    id_vacina = models.ForeignKey(Vacina, on_delete=models.CASCADE, related_name='historico_vacinas')
    id_agendamento = models.ForeignKey(Vacina, on_delete=models.CASCADE, related_name='historico_agendamentos')
    criado_em_dia_mes_ano = models.DateField()

    def __str__(self):
        return f'ID: {self.id_vacina.id}, Vacina: {self.id_vacina.nome}'
    
# Cuidador

class Cuidador(models.Model):
    id_cuidador = models.CharField(max_length=150)
    nome = models.CharField(max_length=150)
    grau_de_parentesco = models.CharField(max_length=150)
    email = models.CharField(max_length=150)
    telefone = models.CharField(max_length=11, unique=True)

    def __str__(self):
        return self.id_cuidador

# Cuidador Criança

class CuidadorCrianca(models.Model):
    id_cuidador = models.ForeignKey(Cuidador, related_name='cuidador', on_delete=models.CASCADE)
    id_crianca = models.CharField(max_length=150)
    criado_em_dia_mes_ano = models.DateField()

    def __str__(self):
        return self.id_crianca

# Criança

class Crianca(models.Model):
    id_crianca = models.ForeignKey(CuidadorCrianca, related_name='criancas', on_delete=models.CASCADE)
    nome_da_crianca = models.CharField(max_length=150)
    cpf = models.CharField(max_length=150)
    data_de_nascimento = models.DateField()
    nome_da_mae = models.CharField(max_length=150)
    cpf_da_mae = models.CharField(max_length=150)
    data_nascimento_mae = models.DateField()
    unidade_saude_familiar = models.CharField(max_length=150)
    maternidade = models.CharField(max_length=150)
    tipo_do_parto = models.CharField(max_length=150)
    idade_gestacional = models.CharField(max_length=150)

# Crescimento Crianca

class CrescimentoCrianca(models.Model):
    idcrescimento = models.AutoField(primary_key=True)
    altura = models.FloatField()  # Altura em centímetros
    peso = models.FloatField()  # Peso em quilogramas
    perimetro = models.FloatField()
    idade = models.IntegerField()
    imc = models.FloatField(null=True, blank=True)  # Campo para armazenar o IMC

    def calcular_imc(self):
        altura_metros = self.altura / 100  # Convertendo altura de centímetros para metros
        imc = self.peso / (altura_metros ** 2)
        return round(imc, 2)  # Arredonda o IMC para 2 casas decimais

    def save(self, *args, **kwargs):
        self.full_clean()  # Chama a função clean antes de salvar
        super(CrescimentoCrianca, self).save(*args, **kwargs)

    def clean(self):
        # Calcula o IMC antes de validar e salvar os dados no banco de dados
        self.imc = self.calcular_imc()
        super(CrescimentoCrianca, self).clean()

# Agendamento

class Agendamento(models.Model):
    Id_Agenda = models.CharField(max_length=50)
    HoraDaVacinacao = models.TimeField()
    DataDeVacinacao = models.DateField()

    def str(self):
        return f'agendamento {self.Id_Agenda}'

# Logradouro

class Logradouro(models.Model):
    Id_Endereco = models.CharField(max_length=100)
    Logradouro = models.CharField(max_length=100)
    Cep = models.CharField(max_length=10)
    Numero = models.CharField(max_length=100)
    Estado = models.CharField(max_length=50)
    Municipio = models.CharField(max_length=20)
    Complemento = models.CharField(max_length=100)

    def str(self):
        return f"{self.Cep}, {self.Numero} - {self.Estado}, {self.Municipio}"

# Endereco

class Endereco(models.Model):
    Id_Endereco = models.CharField(max_length=100)
    Logradouro = models.CharField(max_length=100)
    Cep = models.CharField(max_length=10)
    Numero = models.CharField(max_length=100)
    Estado = models.CharField(max_length=50)
    Municipio = models.CharField(max_length=20)
    Complemento = models.CharField(max_length=100)

    def str(self):
        return f"{self.Cep}, {self.Numero} - {self.Estado}, {self.Municipio}"

# Consulta

class Consulta (models.Model):
    Id_Consulta = models.CharField(max_length=50)
    Id_Medico = models.CharField(max_length=30)
    DataConsulta = models.DateField()
    Id_Endereco = models.CharField(max_length=100)
    TipoDaConsulta = models.CharField(max_length=100)

    def str(self):
        return f"{self.Id_Medico}, {self.DataConsulta}, {self.TipoDaConsulta}"