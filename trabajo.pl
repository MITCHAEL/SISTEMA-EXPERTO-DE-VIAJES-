
%Loguin
usuario(admin).
pass(123456).
usuario(X,Y,Z):-comparausuario(X,Y,Z), write(Z).
comparausuario(X,Y,Z):-usuario(X),pass(Y), Z='USUSARIO CORRECTO'.
comparausuario(X,Y,Z):-not(usuario(X)),not(pass(Y)),Z='USUARIO INCORRECTO'.


%CIUDADES CON AEROPUERTO
pertenece(pucallpa,amazonas).
pertenece(iquitos,amazonas).
pertenece(ayacucho,ayacucho).
pertenece(cusco,cusco).
pertenece(piura,piura).
pertenece(arequipa,arequipa).
pertenece(tarapoto,amazonas).
pertenece(trujillo,'la libertad').
pertenece(chiclayo,lambayeque).
pertenece(juliaca,puno).
pertenece(andahuaylas,apurimac).
pertenece(cajamarca,cajamarca).
pertenece('puerto maldonado','madre de dios').
pertenece(tacna,tacna).
pertenece(piura,piura).
pertenece(talara,piura).
pertenece(lima,lima).
pertenece(tumbes,tumbes).

%VIAJE POR TIERRA
tierra(amazonas,250).
tierra(ancash,70).
tierra(apurimac,50).
tierra(arequipa,90).
%tierra(ayacucho,40).
tierra(cajamarca,130).
tierra(cusco,70).
tierra(huancavelica,30).
tierra(huanuco,80).
tierra(ica,30).
tierra(junin,70).
tierra('la libetad',120).
tierra(lambayeque,140).
tierra(lima,40).
tierra(loreto,400).
tierra('madre de dios',140).
tierra(moquegua,170).
tierra(pasco,70).
tierra(piura,160).
tierra(puno,130).
tierra('san martin',140).
tierra(tacna,170).
tierra(tumbes,200).
tierra(ucayali,160).
%regla precio tierra X: lugar, N: numero de personas
preciotierra(X,N,Y):-tierra(X,A), Y is A*N.

%COSTO DESAYUNO
comida(desayuno,7).
comida(almuerzo,15).
comida(cena, 12).
comidaxdia(X,Y,Z):-comida(X,A), Z is A*Y.


%vuelo desde lima economico
vuelo(lima,54).
vuelo(cusco,59).
vuelo(piura,85).
vuelo(arequipa,68).
vuelo(tarapoto,75).
vuelo(pucallpa,79).
vuelo(iquitos,79).
vuelo(trujillo,112).
vuelo(chiclayo,126).
vuelo(juliaca,104).
vuelo(andahuaylas,109).
vuelo(cajamarca,108).
vuelo(iquitos,101).
vuelo('puerto maldonado',120).
vuelo(tacna,95).
vuelo(piura,79).
vuelo(tarapoto,89).
vuelo(talara,108).
vuelo(tumbes,109).
conectado(lima).
conectado(cusco).
%D: precio del dolar, N numero de personas
preciovuelo(X,N,D,Y):-(conectado(X) ->vuelo(X,B),Y is B*D*N;vuelo(X,A),vuelo(lima,B),Y is (A*D+B*D)*N).

%COSTO ALOJAMIENTO
precioalojamiento(lima,simple,35).
precioalojamiento(lima,doble,40).
precioalojamiento(lima,matrimonial,50).

precioalojamiento(arequipa,simple,20).
precioalojamiento(arequipa,doble,30).
precioalojamiento(arequipa,matrimonial,40).

precioalojamiento(amazonas,simple,40).
precioalojamiento(amazonas,doble,50).
precioalojamiento(amazonas,matrimonial,70).

precioalojamiento(apurimac,simple,32).
precioalojamiento(apurimac,doble,44).
precioalojamiento(apurimac,matrimonial,55).

precioalojamiento(ayacucho,simple,20).
precioalojamiento(ayacucho,doble,30).
precioalojamiento(ayacucho,matrimonial,40).

precioalojamiento(cajamarca,simple,30).
precioalojamiento(cajamarca,doble,40).
precioalojamiento(cajamarca,matrimonial,50).

precioalojamiento(callao,simple,35).
precioalojamiento(callao,doble,40).
precioalojamiento(callao,matrimonial,50).

precioalojamiento(cusco,simple,30).
precioalojamiento(cusco,doble,35).
precioalojamiento(cusco,matrimonial,40).

precioalojamiento(huancavelica,simple,20).
precioalojamiento(huancavelica,doble,30).
precioalojamiento(huancavelica,matrimonial,40).

precioalojamiento(huanuco,simple,20).
precioalojamiento(huanuco,doble,25).
precioalojamiento(huanuco,matrimonial,30).

precioalojamiento(ica,simple,35).
precioalojamiento(ica,doble,40).
precioalojamiento(ica,matrimonial,50).

precioalojamiento(junin,simple,25).
precioalojamiento(junin,doble,30).
precioalojamiento(junin,matrimonial,40).
% regla precio alojamiento X: lugar, Y: tipo de cuarto,N: #decuartos
precioalojamientofinal(X,Y,N,Z):-precioalojamiento(X,Y,A), Z is A*N.


%COSTO DE IDA + ENTRADA A LOS LUGARES TURISTICOS
lugarturistico(chachapoyas,amazonas,50).
lugarturistico(leymebamba,amazonas,25).
lugarturistico('catarata de gocta',amazonas,45).
lugarturistico('pueblo de los muertos',amazonas,45).

lugarturistico('museo ancash', ancash,23).
lugarturistico('laguna 69', ancash,45).
lugarturistico('chavin de huantar',ancash,40).

lugarturistico(choquequirao, apurimac,60).
lugarturistico('santuario nacional del ampay', apurimac,35).
lugarturistico('piedra de saywite', apurimac,25).

lugarturistico('ruinas de incahuasi',huancavelica,35).

lugarturistico(kotosh, huanuco,25).
lugarturistico('complejo arquelogico de huanuco', huanuco,25).
lugarturistico(yarowilca, huanuco,45).

lugarturistico('laguna de huacachina', ica,30).
lugarturistico('pueblo cachiche', ica,40).
lugarturistico('las dunas del desierto', ica,40).

lugarturistico('santuario de chacamarca', junin,60).
lugarturistico('lago junin', junin,45).
lugarturistico(concepcion, junin,35).

lugarturistico('huaca del sol y la luna', 'la libetad',50).
lugarturistico('ruinas de chanchan', 'la libertad',35).
lugarturistico('casa de urquiaga',' la libertad',25).

lugarturistico('tumbas reales de sipan', lambayeque,15).
lugarturistico(tucume, labayeque,25).
lugarturistico('museo nacional de sican', lambayeque,25).

lugarturistico('palacio de la exposicion', lima,60).
lugarturistico('comnplejo arqueologico caral', lima,15).
lugarturistico('estadio nacional', lima,15).

lugarturistico('lago rimachi', loreto,50).
lugarturistico('rio amazonas', loreto,55).
lugarturistico('reserva de pacaya samira', loreto,56).

lugarturistico('parque nacional del manu', 'madre de dios',60).
lugarturistico('reserva ecologico tiracaya', 'madre de dios',65).

lugarturistico('museo contisuyo', moquegua,15).
lugarturistico('malecon costero', moquegua,15).
lugarturistico('la glorieta de ilo',moquegua,23).

lugarturistico('tunqui cueva', pasco,25).
lugarturistico('baños termales la calera',pasco,50).
lugarturistico('jardin botanico missouri', pasco,15).

lugarturistico('mirador kunturwasi',puno,17).
lugarturistico('chullpas de sillustani', puno,15).
lugarturistico('lago titicaca',puno,30).

lugarturistico(tarapoto,'san martin',60).
lugarturistico(moyobamba, 'san martin',63).
lugarturistico('parque nacional del rio abiseo','san martin',30).

lugarturistico('el monumento del alto de la alianza',tacna,15).
lugarturistico('petroglifos de miculla', tacna,15).
lugarturistico('arco parabolico',tacna,30).

lugarturistico('los manglares de tumbes', tumbes,50).
lugarturistico('la isla del amor',tumbas,50).
lugarturistico('caleta de cruz pizarro', tumbes,35).

lugarturistico('provincia de coronel portillo',ucayali,10).
lugarturistico('palacio municipal',ucayali,5).
lugarturistico('plaza del reloj publico', ucayali,5).

lugarturistico(quinua,ayacucho,15).
lugarturistico('vilcas huaman',ayacucho,20).
lugarturistico(luricocha, ayaucho,15).
lugarturistico('pampas galeras', ayacucho,25).

lugarturistico('cañon de cotahuasi',arequipa,90).
lugarturistico('mirador de yanahuara',arequipa,15).
lugarturistico('cañon del colca', arequipa,30).

lugarturistico('cuarto de rescate del inca', cajamarca,35).
lugarturistico('baños del inca',cajamarca,30).
lugarturistico('ventanilla de otuzco',cajamarca,60).

lugarturistico(paita,piura,13).
lugarturistico(sullana,piura,55).
lugarturistico(talara,piura,15).
lugarturistico(sechura,piura,30).
lugarturistico(mancora,piura,20).

lugarturistico(sacsayhuaman, cusco,50).
lugarturistico(machupichu, cusco,450).
lugarturistico(ollantaytambo,cusco,50).

%regla X =lugar; N: numero de personas,
preciolugarturistico(X,Y,N,Z):-lugarturistico(X,Y,A),Z is N*A.

















