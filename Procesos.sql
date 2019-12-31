USE MASTER
GO
IF EXISTS(SELECT * FROM MASTER.sys.sysdatabases 
          WHERE name='Procesos')
BEGIN
    PRINT 'Database Exists'
	DROP DATABASE Procesos;
END

CREATE DATABASE Procesos;
USE Procesos;
go

CREATE TABLE Direccion(
	idDireccion int not null identity(1,1) primary key,
	ciudad varchar(50) not null,
	colonia varchar(50) not null,
	calle varchar(100) not null,
	CP int not null
	);

CREATE TABLE Persona(
	idPersona int not null identity(1,1) primary key,
	nombre varchar(50) not null,
	apellidoP varchar(50) not null,
	apellidoM varchar(50),
	fechaNacimiento varchar(50) not null,
	telefono varchar(50) not null,
	correo varchar(50)not null,
	idDireccion int FOREIGN KEY REFERENCES Direccion(idDireccion)
);

	
CREATE TABLE Departamento(
	idDepartamento int not null identity(1,1) primary key,
	Descripcion varchar(50),
	Presupuesto float
);

CREATE TABLE Rol(
	idRol int not null identity(1,1) primary key,
	Descripcion varchar(50)
);

CREATE TABLE Turno(
	idTurno int not null identity(1,1) primary key,
	Descripcion varchar(50)
);

CREATE TABLE Empleado(
	numEmpleado int not null identity(1,1) primary key,
	idPersona int FOREIGN KEY REFERENCES Persona(idPersona),
	idDepartamento int FOREIGN KEY REFERENCES Departamento(idDepartamento),
	idRol int FOREIGN KEY REFERENCES Rol(idRol),
	idTurno int FOREIGN KEY REFERENCES Turno(idTurno)
);
	
CREATE TABLE Users(
	nameUser varchar(20) not null primary key,
	pass varchar(50) not null,
	imagen varchar(MAX),
	numEmpleado int FOREIGN KEY REFERENCES Empleado(numEmpleado),
);

CREATE TABLE Proveedor(
	nombreCompania varchar(50) not null primary key,
	idPersona int FOREIGN KEY REFERENCES Persona(idPersona)
);

CREATE TABLE Articulo(
	nombreArticulo varchar(50) not null primary key,
	precio float not null
);

CREATE TABLE Compra(
	idPendiente int not null identity(1,1) primary key,
	nameUser varchar(20) FOREIGN KEY REFERENCES Users(nameUser),
	fechaCompra varchar(50) not null,
	cantidad int not null,
	nombreCompania varchar(50) FOREIGN KEY REFERENCES Proveedor(nombreCompania),
	nombreArticulo varchar(50) FOREIGN KEY REFERENCES Articulo(nombreArticulo)
);


CREATE TABLE Correcto(
	idCorrecto int not null identity(1,1) primary key,
	correcto int);

CREATE TABLE Incorrecto(
	idIncorrecto int not null identity(1,1) primary key,
	incorrecto int);
	


CREATE TABLE Cliente(
	  idCliente int NOT NULL identity(1,1) primary key,
	  nombreCompania varchar(50) not null,
	  idPersona int FOREIGN KEY REFERENCES Persona(idPersona)
);

CREATE TABLE Material(
	idMaterial int not null identity(1,1) primary key,
	nombreMaterial varchar(50) not null,
	existencia int,
	precio float not null,
	imagen varchar(MAX),
	idIncorrecto int FOREIGN KEY REFERENCES Incorrecto(idIncorrecto),
	idCorrecto int FOREIGN KEY REFERENCES Correcto(idCorrecto)
);

CREATE TABLE Produccion(
	idProduccion int not null identity(1,1) primary key,
	idMaterial int FOREIGN KEY REFERENCES Material(idMaterial),
	numEmpleado int FOREIGN KEY REFERENCES Empleado(numEmpleado),
	fecha varchar(50) not null
);

CREATE TABLE Cotizar(
	idCotizar int not null primary key
);

CREATE TABLE CotizarMaterial(
	idCotizar int not null,
	idMaterial int not null,
	primary key(idCotizar,idMaterial),
	FOREIGN KEY(idCotizar) REFERENCES Cotizar(idCotizar),
	FOREIGN KEY(idMaterial) REFERENCES Material(idMaterial),
    cantidad int not null

);

CREATE TABLE Factura(
	  num_factura  int NOT NULL PRIMARY KEY IDENTITY(1,1),
	  fecha varchar(50) NOT NULL,
	  fechaVence varchar(50) NOT NULL,
	  idCliente int NOT NULL,
	  idCotizar int NOT NULL
);

CREATE TABLE Modo_pago(
	  idmodo_Pago int NOT NULL primary  key,
	  descripcion varchar(45) NOT NULL
);

CREATE TABLE Pago(
  num_pago int NOT NULL,
  idCliente int not null,
  fecha varchar(100) NOT NULL,
  idmodo_Pago int NOT NULL,
  CONSTRAINT PK_Pago PRIMARY KEY(num_pago,idCliente),
  FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
  FOREIGN KEY (idmodo_Pago) REFERENCES Modo_pago(idmodo_pago)
);


	
go
-- ------------------------------------Inserciones----------------------------------------------------------------------------	
-- -----------------------------Correcto--------------------------------------------------------------------------------------
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
insert into Correcto values(0);
-- ----------------------------Incorrecto-------------------------------------------------------------------------------------
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
insert into Incorrecto values(0);
-- -----------------------------Material--------------------------------------------------------------------------------------

--insert into Material values('Barbie',1450,120.12,'C:/Users/cardiell/Documents/NetBeansProjects/ModuloVentas/src/Imagenes/barbie.jpg',1,1) 

insert into Material values('Barbie',1450,120.12,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/barbie.jpg',1,1) -- nombreMaterial,color,existencia,precio,imagen,idIncorrecto,idCorrecto
insert into Material values('Bebe Elmo',1150,210.43,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/bebe_elmo.jpg',2,2)
insert into Material values('Bozz Lightyear',950,120.15,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/bozz.jpg',3,3)
insert into Material values('Cars Trailer',2450,112.25,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/cars_trailer.jpg',4,4)
insert into Material values('Dinosaurio',1250,62.25,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/dinosaurio.jpg',5,5)
insert into Material values('Enchantimal',3450,141.25,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/enchantimal.jpg',6,6)
insert into Material values('Gimnasio musical',450,211.10,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/gimnasio_musical.jpg',7,7)
insert into Material values('Little People',5450,143.25,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/little_people.jpg',8,8)
insert into Material values('Minirobobita',2425,102,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/minirobobita.jpg',9,9)
insert into Material values('Moustros Apilables',210,65.33,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/moustros_apilables.jpg',10,10)
insert into Material values('Perrito',1200,165.30,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/perrito.jpg',11,11)
insert into Material values('Woody',1210,100,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/woody.jpg',12,12)
insert into Material values('Suicide Squad',1500,115.60,'/home/cardiell/Downloads/ModuloVentas/src/imagenes/suicide_squad.jpg',13,13)

-- ---------------------------Direccion---------------------------------------------------------------------------------------	
insert into Direccion values('Tijuana','morita 1','Pera 2116',22245)--													1
insert into Direccion values('Tijuana','Otay','Avenida 23',21223)--														2
insert into Direccion values('Tijuana','Regugio','Sepa la bola',21443)--												3
insert into Direccion values('Tijuana','Sepa','Sepa',23432)--															4		
insert into Direccion values('Tijuana','Dorado','Rubi',20320)	--														5													
insert into Direccion values('Tijuana','Murua Oriente','Insurgentes 17300-4',12334)--									6
insert into Direccion values('Distrito Federal','Azcapotzalco','Poniente 27A',29502)--								    7
insert into Direccion values('Tijuana','El Porvenir','Principal 16799',22220)--											8
insert into Direccion values('Tijuana','Playas de Tijuana','De la piedra',22506)--										9
insert into Direccion values('Tijuana','Morita 2','Fresa 23431',22245)--                                                10
-- ---------------------------Persona------------------------------------------------------------------------------------------
 
insert into Persona values('Luis','Gonzalez','Cardiel','14-10-1994','9817205','Luis.gonzalez15@uabc.edu.mx',1)--		 1
insert into Persona values('Carlos','Gomez','Cortez','11-01-1982','9214657','Carlogo@CECOMI.com',2)--					 2
insert into Persona values('Alberto','Jaquez','Galvan','10-08-1999','8930483','JaquezAlb@uabc.edu.mx',3)--				 3
insert into Persona values('Ramsses','Palafox',null,'10-07-1997','9859301','Palafox@uabc.edu.mx',4)--                    4
insert into Persona values('Pedro','Rivera','Castillo','10-05-1981','9018503','PedroRivera@IUNI.com',5)--				 5
insert into Persona values('Erick','Gustamante','Fernanez','10-02-19985','6272516','info@maq-elevacion.com',6)--		 6
insert into Persona values('Fabian','Cortez','Villega','10-10-1982','5556-9308','ventas@univerplast.com.mx',7)--         7
insert into Persona values('Armando','Nieblas','Ruvalcaba','06-07-1994','6259003','pedidos@industrialsafety.com.mx',8)-- 8
insert into Persona values('Antonio','Rodriguez','Diaz','02-04-1975','4279609','antonio.rodriguez@uabc.edu.mx',9)--		 9
insert into Persona values('Jose Antonio','Guzman','Fernandez','02-04-1975','9230452','jose12@uabc.edu.mx',10)--         10

-- ---------------------------Cliente-------------------------------------------------------------------------------------------
insert into Cliente values('Raptor',10)

-- --------------------------Departamento---------------------------------------------------------------------------------------	

insert into Departamento values('Compras',15000000)--																			 1
insert into Departamento values('Ventas',100000)--																				 2
insert into Departamento values('Mantenimiento',1000000)--																		 3
insert into Departamento values('Almacen',5000000)--																			 4
insert into Departamento values('Produccion',10000000)--																		 5

-- --------------------------------Rol-----------------------------------------------------------------------------------------	
insert into Rol values('Admin') --																						 1
insert into Rol values('Director')--																					 2
insert into Rol values('Gerente')--																						 3
insert into Rol values('Administrativo')--																				 4
insert into Rol values('Jefe')--																						 5
insert into Rol values('Operador')--																					 6

-- --------------------------------TURNO---------------------------------------------------------------------------------	

insert into Turno values('Manana')--																					 1
insert into Turno values('Tarde')--																						 2
insert into Turno values('Noche')--																						 3

-- -------------------------------Empleado-------------------------------------------------------------------------------
	
insert into Empleado values(1,2,4,1)--idPersona,idDepartamento,idRol,idTurno											 1
insert into Empleado values(3,1,3,1)--	Alberto																			 2
insert into Empleado values(4,5,5,2)--  Palafox                                                                          3
insert into Empleado values(9,1,4,1)--  profe																			 4
-- --------------------------------Users------------------------------------------------------------------------------------	
insert into Users values('Cardiell','mattel',null,1)-- NombreUsuario,pass,imagen,numeroEmpleado							 1
insert into Users values('Jaquezal','mattel',null,2)--																     2
insert into Users values('PalafoxR','mattel',null,3)--																	 3
insert into Users values('DiazAnto','mattel',null,4)
-- -----------------------------Proveedor-----------------------------------------------------------------------------------
	
insert into Proveedor values('CECOMI',2)--idCompania,idPersona
insert into Proveedor values('IUNI',5)
insert into Proveedor values('MDE',6)
insert into Proveedor values('UniverPlast',7)
insert into Proveedor values('Industrial Safety',8)

-- -----------------------------Articulo------------------------------------------------------------------------------------
	
insert into Articulo values('Resina Blanca',20.12)-- idArticulo,precio
insert into Articulo values('Resina Roja',120.23)
insert into Articulo values('Resina Verde',70.55)
insert into Articulo values('Resina Azul',60.12)
insert into Articulo values('Tapones',0.00060)
insert into Articulo values('Casco',110.45)
insert into Articulo values('Botas',1230.43)
insert into Articulo values('Lentes',34.93)
insert into Articulo values('Chaleco',220.43)
insert into Articulo values('Contenedor',850.00)
insert into articulo values('Palet',1823.43)
insert into Articulo values('Montacargas',23430.00)
insert into Articulo values('Elevador de Tijera',21430.00)
insert into Articulo values('Jirafa',34234)
-- --------------------------------Compra-----------------------------------------------------------------------------------
	
insert into Compra values('Cardiell','2018-05-19',10,'CECOMI','jirafa') --Usuario,Fecha,cantidad,idCompania,idArticulo
insert into Compra values('JaquezAl','2018-05-19',500,'CECOMI','Casco')
insert into Compra values('PalafoxR','2018-05-19',1000,'IUNI','Tapones')
insert into Compra values('Diazanto','2018-05-19',1000,'IUNI','Resina Blanca')
insert into Compra values('Palafoxr','2018-05-19',5000,'IUNI','Resina Roja')
insert into Compra values('Cardiell','2018-05-19',100,'IUNI','Resina Verde')
insert into Compra values('Diazanto','2018-05-19',200,'IUNI','Resina Azul')
insert into Compra values('Palafoxr','2018-05-19',1265,'MDE','Botas')
insert into Compra values('jaquezal','2018-05-19',1000,'UniverPlast','Botas')
insert into Compra values('jaquezal','2018-05-19',2000,'UniverPlast','lentes')
insert into Compra values('jaquezal','2018-05-19',2000,'UniverPlast','Chaleco')
insert into Compra values('jaquezal','2018-05-19',2000,'UniverPlast','Contenedor')
insert into Compra values('cardiell','2018-05-19',2250,'UniverPlast','Palet')
insert into Compra values('JaquezAl','2018-05-19',50,'CECOMI','Montacargas')
insert into Compra values('JaquezAl','2018-05-19',10,'CECOMI','Elevador de Tijera')
-- -------------------------------------------------------------------------------------------------------------------------	
go
-- ------------------------------------------PEDIMENTO---------------------------------------------------------------------	
create procedure SelectPresupuesto(
	@nombreArticulo varchar(50))
as
select com.idPendiente,
	   com.nameUser,
	   com.nombreArticulo,
	   com.cantidad,
	   com.fechaCompra,
	   com.nombreCompania,
	   per.correo,
	   per.telefono,
	   art.precio
	   
	   from Compra com
	   inner join Proveedor prov
	   on prov.nombreCompania = com.nombreCompania
	   
	   inner join Persona per
	   on per.idPersona = prov.idPersona

	   inner join Articulo art
	   on art.nombreArticulo = com.nombreArticulo

	   where art.nombreArticulo=@nombreArticulo;

go

create procedure ListarPedimento
as
select com.idPendiente,
	   com.nameUser,
	   com.nombreArticulo,
	   com.cantidad,
	   com.fechaCompra,
	   com.nombreCompania,
	   per.correo,
	   per.telefono

	   from Compra com
	   inner join Proveedor prov
	   on prov.nombreCompania = com.nombreCompania
	   
	   inner join Persona per
	   on per.idPersona = prov.idPersona
go
create procedure buscarPedimento(
	@nombreCompania varchar(50))
as

select com.idPendiente,
	   com.nameUser,
	   com.nombreArticulo,
	   com.cantidad,
	   com.fechaCompra,
	   com.nombreCompania,
	   per.correo,
	   per.telefono

	   from Compra com
	   inner join Proveedor prov
	   on prov.nombreCompania = com.nombreCompania
	   
	   inner join Persona per
	   on per.idPersona = prov.idPersona

	where com.nombreArticulo Like CONCAT(@nombreCompania,'%');

	go

create procedure OkArticulo(
	@nombreArticulo varchar(50))
	as
		select COUNT(*) from Articulo where nombreArticulo = @nombreArticulo;

go

create procedure OkProveedor(
	@nombreCompania varchar(50))
	as
select COUNT(*) from Proveedor where nombreCompania = @nombreCompania;

go
create procedure OkUser(
	@nameUser varchar(50))
	as
select COUNT(*) from Users where nameUser=@nameUser


-- ------------------------------------------------------------------------------------------------------------------------	
go
-- -----------------------------------------------DIRECCION----------------------------------------------------------------

create procedure ListarDireccion
as
select *from Direccion

go

create procedure AgregarDireccion(
	@ciudad varchar(50),
	@colonia varchar(50),
	@calle varchar(100),
	@cp int
	)
as

insert into Direccion values(@ciudad,@colonia,@calle,@cp);

go

create procedure UpdateDireccion(
	@idDireccion int,
	@ciudad varchar(50),
	@colonia varchar(50),
	@calle varchar(100),
	@cp int
	)
as
update Direccion set ciudad=@ciudad,colonia=@colonia,calle=@calle,cp=@cp where idDireccion= @idDireccion;

-- ------------------------------------------------------------------------------------------------------------------------	
go
-- ----------------------------------------------ROL-----------------------------------------------------------------------
           
create procedure ListarRol
as
select *from Rol

go

create procedure AgregarRol(
	@Descripcion varchar(50)
	)
as

insert into Rol values(@Descripcion);

go

create procedure UpdateRol(
	@idRol int,
	@Descripcion varchar(50)
	)
as
update Rol set Descripcion=@Descripcion where idRol= @idRol;
-- ------------------------------------------------------------------------------------------------------------------------	
go
-- ----------------------------------------------Turno---------------------------------------------------------------------
           
create procedure ListarTurno
as
select *from Turno

go

create procedure AgregarTurno(
	@Descripcion varchar(50)
	)
as

insert into Turno values(@Descripcion);

go

create procedure UpdateTurno(
	@idTurno int,
	@Descripcion varchar(50)
	)
as
update Turno set Descripcion=@Descripcion where idTurno= @idTurno;
-- ------------------------------------------------------------------------------------------------------------------------	
go
-- ----------------------------------------------Users---------------------------------------------------------------------
           
create procedure ListarUser
as
select *from Users

go

CREATE PROCEDURE UserRegistrado(
	@nameUser varchar(50),
	@pass varchar(50))
	as
select COUNT(*) from Users where nameUser=@nameUser and pass=@pass;

go

create procedure ListarLogin(
	@nameUser varchar(50))
as
select  us.nameUser,
	us.pass,
	us.imagen,
	num.numEmpleado,
	num.idRol,
	num.idDepartamento
		
		from Users us	
			inner join Empleado num
			on num.numEmpleado= us.numEmpleado
where nameUser =@nameUser

go

create procedure AgregarUser(
	@nameUser varchar(20),
	@pass varchar(50),
	@imagen varchar(max),
	@numEmpleado int
	)
as

insert into Users values(@nameUser,@pass,@imagen,@numEmpleado);

go

create procedure UpdateUser(
	@nameUser varchar(20),
	@pass varchar(50),
	@imagen varchar(MAX),
	@numEmpleado int
	)
as
update Users set pass=@pass,imagen=@imagen,numEmpleado=@numEmpleado where nameUser= @nameUser;
-- ------------------------------------------------------------------------------------------------------------------------	
go
-- ----------------------------------------------Articulo---------------------------------------------------------------------
           
create procedure ListarArticulo
as
select *from Articulo

go

create procedure AgregarArticulo(
	@nombreArticulo varchar(50),
	@precio float
	)
as

insert into Articulo values(@nombreArticulo,@precio);

go

create procedure UpdateArticulo(
	@nombreArticulo varchar(50),
	@precio float
	)
as
update Articulo set precio=@precio where nombreArticulo= @nombreArticulo;
-- ------------------------------------------------------------------------------------------------------------------------	
go
-- ------------------------------------------Proveedor---------------------------------------------------------------------
           
create procedure ListarProveedor
as
select *from Proveedor

go

create procedure AgregarProveedor(
	@nombreCompania varchar(50),
	@idPersona int
	)
as

insert into Proveedor values(@nombreCompania,@idPersona);

go

create procedure UpdateProveedor(
	@nombreCompania varchar(50),
	@idPersona int
	)
as
update Proveedor set idPersona=@idPersona where nombreCompania= @nombreCompania;
-- ------------------------------------------------------------------------------------------------------------------------	
go
-- -------------------------------------------Departamento-----------------------------------------------------------------
           
create procedure BuscarDepartamento(
	@idDepartamento int)
as
select *from Departamento where idDepartamento = @idDepartamento;
go

create procedure ListarDepartamento
as
select *from Departamento

go

create procedure AgregarDepartamento(
	@Descripcion varchar(50),
	@Presupuesto float
	)
as

insert into Departamento values(@Descripcion,@Presupuesto);

go

create procedure UpdateDepartamento(
	@idDepartamento int,
	@Descripcion varchar(50),
	@Presupuesto float
	)
as
update Departamento set Descripcion=@Descripcion,Presupuesto=@Presupuesto where idDepartamento= @idDepartamento;




-- ------------------------------------------------------------------------------------------------------------------------
go
-- -----------------------------------------------COMPRA--------------------------------------------------------------------	
                             
create procedure ListarCompra
as
select *from Compra

go

create procedure AgregarCompra(
	@nameUser varchar(20),
	@fechaCompra varchar(100),
	@cantidad int,
	@nombreCompania varchar(50),
	@nombreArticulo varchar(50)
	)
as

insert into Compra values(@nameUser,@fechaCompra,@cantidad,@nombreCompania,@nombreArticulo);

go

create procedure UpdateCompra(
	@idPendiente int,
	@nameUser varchar(20),
	@fechaCompra varchar(100),
	@cantidad int,
	@nombreCompania varchar(50),
	@nombreArticulo varchar(50)
	)
as
update Compra set nameUser=@nameUser,fechaCompra=@fechaCompra,cantidad=@cantidad,nombreCompania=@nombreCompania,nombreArticulo=@nombreArticulo where idPendiente= @idPendiente;

-- ------------------------------------------------------------------------------------------------------------------------	
go
-- -------------------------------------------------PERSONA----------------------------------------------------------------	
create procedure ListarPersona
as
select *from Persona

go

create procedure AgregarPersona(
	@nombre varchar(50),
	@apellidoP varchar(50),
	@apellidoM varchar(50),
	@fechaNacimiento varchar(50),
	@telefono varchar(50),
	@correo varchar(50),
	@idDireccion int
	)
as

insert into Persona values(@nombre,@apellidoP,@apellidoM,@fechaNacimiento,@telefono,@correo,@idDireccion);

go

create procedure UpdatePersona(
	@idPersona int,
	@nombre varchar(50),
	@apellidoP varchar(50),
	@apellidoM varchar(50),
	@fechaNacimiento varchar(50),
	@telefono varchar(50),
	@correo varchar(50),
	@idDireccion int
	)
as
update Persona set nombre=@nombre,apellidoP=@apellidoP,apellidoM=@apellidoM,fechaNacimiento=@fechaNacimiento,telefono=@telefono,correo=@correo,idDireccion=@idDireccion where idPersona= @idPersona;

-- ------------------------------------------------------------------------------------------------------------------------
go
-- -----------------------------------------------EMPLEADO------------------------------------------------------------------	
create procedure ListarEmpleado
as
select *from Empleado

go

create procedure AgregarEmpleado(
	@idPersona int,
	@idDepartamento int,
	@idRol int,
	@idTurno int
	)
as

insert into Empleado values(@idPersona,@idDepartamento,@idRol,@idTurno);

go

create procedure UpdateEmpleado(
	@numEmpleado int,
	@idPersona int,
	@idDepartamento int,
	@idRol int,
	@idTurno int
	)
as
update Empleado set idPersona=@idPersona,idDepartamento=@idDepartamento,idRol=@idRol,idTurno=@idTurno where numEmpleado= @numEmpleado;
-- ------------------------------------------------------------------------------------------------------------------------
go
-- -----------------------------------------------CLIENTE------------------------------------------------------------------	
create procedure ListarCliente
as
select *from Cliente

go

create procedure OkCliente(
	@nombreCompania varchar(50))
	as
		select COUNT(*) from Cliente where nombreCompania = @nombreCompania;
go

create procedure BuscarCliente(
	@nombreCompania varchar(50)
)
as
select *from Cliente where nombreCompania= @nombreCompania;

go

create procedure AgregarCliente(
	@nombreCompania varchar(50),
	@idPersona int
	)
as

insert into Cliente values(@nombreCompania,@idPersona);

go

create procedure UpdateCliente(
	@idCliente int,
	@nombreCompania varchar(50),
	@idPersona int
	)
as
update Cliente set nombreCompania=@nombreCompania,idPersona=@idPersona where idCliente= @idCliente;
-- ------------------------------------------------------------------------------------------------------------------------	
go
-- -----------------------------------------------Produccion---------------------------------------------------------------

create procedure ListarProduccion
as
select *from Produccion

go

create procedure AgregarProduccion(
	@idMaterial int,
	@numEmpleado int,
	@fecha varchar(50)
	)
as

insert into Produccion values(@idMaterial,@numEmpleado,@fecha);

go

create procedure UpdateProduccion(
	@idProduccion int,
	@idMaterial int,
	@numEmpleado int,
	@fecha varchar(50)
	)
as
update Produccion set idMaterial=@idMaterial,numEmpleado=@numEmpleado,fecha=@fecha where idProduccion= @idProduccion;

-- ------------------------------------------------------------------------------------------------------------------------	
go
-- -----------------------------------------------Material-----------------------------------------------------------------

create procedure buscarMaterial(
	@nombreMaterial varchar(50))
as

select *from Material where nombreMaterial Like CONCAT('%',@nombreMaterial,'%');

go

create procedure buscarMaterialId(
	@idMaterial int)
as
select *from Material where idMaterial = @idMaterial;
go
create procedure ListarMaterial
as
select *from Material

go

create procedure AgregarMaterial(

	@nombreMaterial varchar(50),
	@existencia int,
	@precio float,
	@imagen varchar(max),
	@idIncorrecto int,
	@idCorrecto int
	)
as

insert into Material values(@nombreMaterial,@existencia,@precio,@imagen,@idIncorrecto,@idCorrecto);

go

create procedure UpdateMaterial(
	@idMaterial int,
	@nombreMaterial varchar(50),
	@existencia int,
	@precio float,
	@imagen varchar(max),
	@idIncorrecto int,
	@idCorrecto int
	)
as
update Material set nombreMaterial=@nombreMaterial,existencia=@existencia,precio=@precio,imagen=@imagen,idInCorrecto=@idInCorrecto,IdCorrecto=@idCorrecto where idMaterial= @idMaterial;

--  --------------------------------------------CORRECTO-----------------------------------------------------------------
go
-- ----------------------------------------------------------------------------------------------------------------------


create procedure ListarCorrecto
as
select *from Correcto

go

create procedure AgregarCorrecto(
	@correcto int)
as
insert into Correcto values(@correcto);

go

create procedure UpdateCorrecto(
	@idCorrecto int,
	@correcto int
	)
as
update Correcto set correcto=@correcto where idCorrecto= @idCorrecto;

-- ------------------------------------------INCORRECTO---------------------------------------------------------------------
go
-- -------------------------------------------------------------------------------------------------------------------------
create procedure ListarIncorrecto
as
select *from Correcto

go

create procedure AgregarIncorrecto(
	@incorrecto int)
as
insert into Incorrecto values(@incorrecto);

go

create procedure UpdateIncorrecto(
	@idIncorrecto int,
	@incorrecto int
	)
as
update Incorrecto set incorrecto=@incorrecto where idIncorrecto= @idIncorrecto;
-- -------------------------------------------------------COTIZARMATERIAL---------------------------------------------------------------------------------------
go
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------
create procedure ListarCotizarMaterial(
	@idCotizar int
)
as
select *from CotizarMaterial where idCotizar=@idCotizar;
go
create procedure ListarCotizacionMaterial
as
select *from CotizarMaterial;
go
create procedure AgregarCotizarMaterial(
	@idCotizar int,
    @idMaterial int,
	@cantidad	int

	)
as
insert into CotizarMaterial values(@idCotizar,@idMaterial,@cantidad);
go

create procedure UpdateCotizarMaterial(
	@idCotizar int,
	@idMaterial int,
	@cantidad int

)
as
update  CotizarMaterial set cantidad=@cantidad where (idCotizar= @idCotizar and idMaterial=@idMaterial);
go
create procedure OkCotizarMaterial(
	@idCotizar int,
	@idMaterial int)
	as
select COUNT(*) from CotizarMaterial where idCotizar=@idCotizar and idMaterial=@idMaterial;
go
create procedure BuscarCotizarMaterial(
	@idCotizar int,
	@idMaterial int
)
as
select *from CotizarMaterial where (idMaterial=@idMaterial and idCotizar=@idCotizar);
-- -------------------------------------------------------COTIZAR-----------------------------------------------------------------------------------------------
go
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------
create procedure OkCotizar(
	@idCotizar int)
	as
select COUNT(*) from Cotizar where idCotizar=@idCotizar;
go
create procedure ListarCotizacion
as
select *from Cotizar;
go
create procedure AgregarCotizar(
	@idCotizar int
	)
as
insert into Cotizar values(@idCotizar);
go

-- -------------------------------------------------Factura------------------------------------------------------------------------------------------
go
-- --------------------------------------------------------------------------------------------------------------------------------------------------
create procedure ListarFactura
as
select *from Factura

go


create function Total(@idFactura int)
RETURNS int
AS
BEGIN
     DECLARE @total int;

	select @total=SUM(co.cantidad*mat.precio) 
	From Factura fac
	inner join CotizarMaterial co
	on co.idCotizar = fac.idCotizar
	inner join Material mat
	on mat.idMaterial=co.idMaterial
	where @idFactura= @idFactura;
	return @total;
	END;  

go

create procedure buscarFactura(
	@nombreCompania varchar(50))
as
select fac.num_factura,
	   fac.fecha,
	   cli.nombreCompania,
	   per.telefono,
	   per.correo,
	   dir.colonia,
	   dir.calle,
	   per.nombre,
	   per.apellidoP


	from Factura fac
	inner join Cliente cli
	on cli.idCliente=fac.idCliente
	inner join Persona per
	on per.idPersona = cli.idPersona
	inner join Direccion dir
	on dir.idDireccion = per.idDireccion
	inner join CotizarMaterial co
	on co.idCotizar = fac.idCotizar
	inner join Material mat
	on mat.idMaterial = co.idMaterial

	where cli.nombreCompania Like CONCAT(@nombreCompania,'%')
		group by num_factura,fecha,cli.nombreCompania,
	   per.telefono,
	   per.correo,
	   dir.colonia,
	   dir.calle,
	   per.nombre,
	   per.apellidoP;

	go



create procedure MostrarFactura
as
--Declare @total int;
--exec @total =Total @idFactura=@idFac;
select fac.num_factura,
	   fac.fecha,
	   cli.nombreCompania,
	   per.telefono,
	   per.correo,
	   dir.colonia,
	   dir.calle,
	   per.nombre,
	   per.apellidoP


	from Factura fac
	inner join Cliente cli
	on cli.idCliente=fac.idCliente
	inner join Persona per
	on per.idPersona = cli.idPersona
	inner join Direccion dir
	on dir.idDireccion = per.idDireccion
	inner join CotizarMaterial co
	on co.idCotizar = fac.idCotizar
	inner join Material mat
	on mat.idMaterial = co.idMaterial
	group by num_factura,fecha,cli.nombreCompania,
	   per.telefono,
	   per.correo,
	   dir.colonia,
	   dir.calle,
	   per.nombre,
	   per.apellidoP;
go
create procedure AgregarFactura(
	  @fecha varchar(50),
	  @fechaVence varchar(50),
	  @idCliente int,
	  @idCotizar int
	)
as

insert into Factura values(@fecha,@fechaVence,@idCliente,@idCotizar);


go

create procedure UpdateFactura(
	  @num_factura  int,
	  @fecha varchar(50),
	  @fechaVence varchar(50),
	  @idCliente int,
	  @idCotizar int
	)
as
update Factura set fecha=@fecha,fechaVence=@fechaVence,idCliente=@idCliente,idCotizar=@idCotizar where num_factura= @num_factura;

--,Modo_pago,Pago
