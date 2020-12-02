import { Selector } from 'testcafe';

fixture `Pruebas automáticas`
    .page `http://localhost:8080/`;

test('Test N°1: Visualización Plan de Negocio', async t => {

    const planPart1 = Selector('#collapseTierra').textContent;
    const planPart2 = Selector('#collapseTrabajo').textContent;
    const planPart3 = Selector('#collapsePatrimonio').textContent;
    const planPart4 = Selector('#cardPart1').textContent;
    const planPart5 = Selector('#cardPart2').textContent;
    const planPart6 = Selector('#cardPart3').textContent;
    const planPart7 = Selector('#pills-tiempo').textContent;

    await t
        .maximizeWindow()
        .click('#loginButton')
        .typeText('#inputEmail','usuario@usuario.com')
        .typeText('#inputPassword','12345678')
        .click('#signButton')
        .click('#pills-requisitos-tab')
        .click('#planButton1')
        .click('#tierraButton')
        .expect(planPart1).contains("Puesto que usted está comenzando una plantación de palma de aceite")
        .wait(1000)
        .takeScreenshot()
        .click('#trabajoButton')
        .expect(planPart2).contains("Aunque es posible que no tenga que contratar personal permanente, tendrá que contratar a personas para ayudarle")
        .wait(1000)
        .takeScreenshot()
        .click('#patrimonioButton')
        .expect(planPart3).contains("Esto se refiere al dinero que se requiere para iniciar el negocio. Esto incluye el costo de adquisición")
        .wait(1000)
        .takeScreenshot()
        .click('#backButton')
        .click('#pills-preparacion-tab')
        .click('#planButton2')
        .expect(planPart4).contains("Comprar las plantas de semillero que va a plantar. A pesar de que usted tiene")
        .expect(planPart5).contains("Plantar la plántula en el terreno ya preparado. Asegúrese de que haya un espacio")
        .expect(planPart6).contains("Eliminar las malas hiervas y aplicar fertilizantes a las plantas a intervalos")
        .takeScreenshot()
        .click('#backButton')
        .click('#pills-tiempo-tab')
        .expect(planPart7).contains("Su primera cosecha será de alrededor de dos años después de la plantación de plántulas.")
        .takeScreenshot()
        
});

