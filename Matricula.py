from Mensajes import Mensajes

class Matricula:
  
  def __init__(self, codigo, nota, codEstudiante, codProfesor, codMateria, estudiante, profesor, materia):
    self._codigo = codigo
    self._nota = nota
    self._codEstudiante = codEstudiante
    self._codProfesor = codProfesor
    self._codMateria = codMateria
    self._estudiante = estudiante
    self._profesor = profesor
    self._materia=materia
  
  def getCodigo(self):
    return self._codigo
    
  def setCodigo(self, codigo):
    self._codigo = codigo
    
  def getNota(self):
    return self._nota
    
  def setNota(self, nota):
    self._nota = nota

  def setEstudiante(self, estudiante):
  	self._estudiante = estudiante

  def getEstudiante(self):
  	return self._estudiante

  def getProfesor(self):
      return self._profesor

  def setProfesor(self, profesor):
      self._profesor = profesor

  def getMateria(self):
  	return self._materia

  def setMateria(self, materia):
  	self._materia = materia

  def setCodEstudiante(self, codEstudiante):
    self._codEstudiante = codEstudiante

  def getCodEstudiante(self):
    return self._codEstudiante

  def setCodProfesor(self, codProfesor):
    self._codProfesor = codProfesor

  def getCodProfesor(self):
    return self._codProfesor

  def setCodMateria(self, codMateria):
    self._codMateria = codMateria

  def getCodMateria(self):
    return self._codMateria

  def toString(self):
  	return ("Matricula: { Codigo: " + self.getCodigo() + ", Nota: " + self.getNota() + ", Estudiante: " + self.getEstudiante().getNombre() + ", Profesor: " 
    + self.getProfesor().getNombre() + ", Materia: " + self.getMateria().getNombre() + " }")

  @staticmethod
  def consultarMatricula(listaMatricula, codigo):
    for matricula in listaMatricula:
      if matricula.getCodigo() == codigo:
        return matricula
    return None

  @staticmethod
  def consultarMatriculas(listaMatricula):
    result=""
    if(listaMatricula==None):
      return result
    for matricula in listaMatricula:
      if(matricula.getCodigo() != None):
        result+="\n"+ matricula.toString()
    return result

  def display_menuMatriculas():
    print (Mensajes.mensajesMatricula['menu'] + " :","\n 1.", Mensajes.mensajesMatricula['crear'], "\n 2.", Mensajes.mensajesMatricula['verNota'] , "\n 3." , 
    	Mensajes.mensajesMatricula['asignarNota'] , "\n 4." , Mensajes.mensajesMatricula['editarNota'],"\n 5." , 
    	Mensajes.mensajesMatricula['mejorPromedio'],"\n 6." , Mensajes.mensajesMatricula['estudiantesPorMateria'],"\n 7." , 
    	Mensajes.mensajesMatricula['notaMasBaja'],"\n 8." , Mensajes.mensajesMatricula['notaMasAlta'])

  def editarNota(self, nota):
  	self.setNota(nota)

  @staticmethod
  def mejorPromedio(listaMatriculas,listaMaterias):
      mejorPromedioPorMateria=""
      resultado=[]
      for materia in listaMaterias:
        mayor=0
        for matricula in listaMatriculas:
          if matricula.getCodMateria() == materia.getNombre() and matricula.getNota()!='':
            if float(matricula.getNota()) > mayor:
              mayor=float(matricula.getNota())
              mejorPromedioPorMateria=matricula.toString()
        resultado.append(mejorPromedioPorMateria)
      return resultado
  
  @staticmethod
  def estudiantesPorMateria(listaMatriculas,listaMaterias):
      for materia in listaMaterias:
        print("MATERIA :", materia.getNombre())
        for matricula in listaMatriculas:
          if(matricula.getMateria().getNombre()==materia.getNombre()):
            print("ESTUDIANTE :", matricula.getEstudiante().getNombre())

  @staticmethod
  def notaMasAlta(listaMatriculas):
      mayorNota = 0
      resultado =""
      for matriculas in listaMatriculas:
        if(float(matriculas.getNota()) > mayorNota):
          mayorNota = float(matriculas.getNota())
          resultado = matriculas.toString()
      return ("El estudiante con mayor nota es: " + resultado)
  
  @staticmethod
  def notaMasBaja(listaMatriculas):
      menorNota = 5
      resultado = ""
      for matriculas in listaMatriculas:
        if(float(matriculas.getNota()) <= menorNota):
          menorNota = float(matriculas.getNota())
          resultado = matriculas.toString()
      return ("La menor nota es: " + resultado)

#Este metodo es utilizado para eliminar las instancias de una matricula cuando se elimina un estudiante o profesor
  @staticmethod
  def borrarMatriculas(listaMatricula):
    for matricula in listaMatricula:
      matricula.setCodigo(None)