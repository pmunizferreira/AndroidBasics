# AndroidBasics
<h1>Conceitos Básicos de Android</h1>
O Android é um SO baseado em Java, por isso precisa de um Java Software Development Kit (SDK or "devkit").

<blockquote>"The remainder of the SDK is composed of extra software, such as Application Servers, Debuggers, and Documentation.</blockquote>
    
Dentro do SDK para o Android, existem várias ferramentas úteis para o desenvolvimento de aplicaões.
      
<blockquote>
<b>ADB - Android Debug Bridge</b><br>
Permite acessar o dispositivo Android e executar diversos comandos (install, unisntall, shell, logcat)
</blockquote>
<blockquote>      
<b>AVD - Android Virtual Device</b><br>
Permite a criação de emuladores de dispositivos Android.
</blockquote>

De posse do Android SDK e suas ferramentas utilitárias, a IDE pode controlar o dispositivo.

Para iniciar um projeto Android, precisamos:

    1. Instalar a IDE Android Studio já com o SDK do Android
    https://developer.android.com/studio/index.html
    
    2. Para configurar o SDK Manager, vá em Tools -> Android -> SDK Manager
    No SDK Manager, é possível instalar uma ou mais versões do Android.
    Selecione a plataforma Android que deseja. Assegure-se de que Android SDK Tools e Android SDK Plataform-tools estejam selecionados, pois são neles que estarão o ADB e o AVD.
    
    3. Para configurar um emulador, vá em Tools -> Android -> AVD Manager

<h3>Alternativa ao Android Studio</h3>
Caso deseje outra IDE, como o Atom, é preciso configurar o SDK, o ADB e o AVD manualmente.
Caso a IDE escolhida não tenha integração direta com o SDK, é preciso executar os comandos em um prompt.

    1. Faça download do Mac SDK Tools em http://developer.android.com/sdk/index.html#mac-tools
    
    2. Descompacte o arquivo em uma pasta. No exemplo abaixo, substitua <%user%> por seu usuário na máquina. 
    Se desejar, troque o caminho por uma pasta de sistema.
    unzip android-sdk*.zip /Users/<%user%>/Library/Android/sdk
    
    3. Execute o SDK Manager
    sh /Users/<%user%>/Library/Android/sdk/tools/android
    
    4. No SDK Mnager, é possível instalar uma ou mais versões do Android. Selecione a plataforma Android que deseja. Assegure-se de que Android SDK Tools e Android SDK Plataform-tools estejam selecionados, pois são neles que estarão o ADB e o AVD.
    As plataformas escolhidas estarão em /Users/<%user%>/Library/Android/sdk/plataforms/
    O ADB estará em /Users/<%user%>/Library/Android/sdk/plataform-tools/
    
    5. Para que os ADB possa ser executado fora da sua pasta, adicione seu caminho ao path da máquina  
    export PATH="/Users/<%user%>/Library/Android/sdk/platform-tools":$PATH
    
    6. Para configurar um emulador, abra o SDK Manager, Tools -> Manage AVDs
    
    7. Para listar os devices (físicos os emuladores)
    adb devices
    
    8. Para desinstalar ums aplicação em um device
    adb uninstall <%nome do pacote%>
    ex: adb uninstall com.tw.mobile
    
    Caso haja mais de um device conectado ao adb, execute o comando com o ID deste device, listado no comando "adb devices"
    adb -s <%device_id%> uninstall com.tw.mobile
    
    9. Para instalar um aplicativo em um device
    adb install app.apk
    
    10. Para visualizar o log do aparelho
    adb logcat
    
    11. Para ver logs apenas de uma aplicação
    adb logcat <your package name>:<log level> *:S
