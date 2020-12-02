import { Selector } from 'testcafe';

fixture `Pruebas automáticas`
    .page `http://localhost:8080/`;

test('Test N°2: Respuesta de expertos a asesorías', async t => {

    const textoRespuesta = "Test automático"
    const respuestaContent = Selector('#respuestaId').textContent;

    await t
        .maximizeWindow()
        .click('#loginButton')
        .typeText('#inputEmail','admin@admin.com')
        .typeText('#inputPassword','12345678')
        .click('#signButton')
        .click('#asesoriaId')
        .click('#responderButton')
        .click('#limpiarButton')
        .typeText('#output', textoRespuesta)
        .takeScreenshot()
        .click('#guardarButton')
        .expect(respuestaContent).eql(textoRespuesta)
        .takeScreenshot();
});
