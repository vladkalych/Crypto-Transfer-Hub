let previousConnection;

async function getConnection() {
    let isOnlineResponse = await fetch('http://localhost:8091/connection');
    return await isOnlineResponse.json();
}

async function firstConnection() {
    previousConnection = await getConnection();
    showIsOnlineHTML(previousConnection);
}

async function testConnection() {
    let currentConnection = await getConnection();

    if (previousConnection === currentConnection){
        return;
    }

    removeIsOnlineHTML();
    showIsOnlineHTML(previousConnection);
}

function showIsOnlineHTML(currentConnection){
    if (currentConnection){
        showOnline();
        return;
    }

    showOffline();
}

function showOffline() {
    let nanoContentHTML = document.getElementById('nano-content');
    let logoContainer = document.getElementById('logo-container');

    let isOnlineHTML = document.createElement('div');
    isOnlineHTML.id = 'isOnline';

    let label = document.createElement('p');

    isOnlineHTML.className = 'server-offline-style';
    label.innerText = 'Server is offline';
    isOnlineHTML.appendChild(label);
    nanoContentHTML.insertBefore(isOnlineHTML, logoContainer);

    // setTimeout(removeIsOnlineHTML, 2000);
}

function showOnline() {
    let nanoContentHTML = document.getElementById('nano-content');
    let logoContainer = document.getElementById('logo-container');

    let isOnlineHTML = document.createElement('div');
    isOnlineHTML.id = 'isOnline';

    let label = document.createElement('p');

    isOnlineHTML.className = 'server-online-style';
    label.innerText = 'Server is online';
    isOnlineHTML.appendChild(label);
    nanoContentHTML.insertBefore(isOnlineHTML, logoContainer);

    setTimeout(removeIsOnlineHTML, 2000);
}

function removeIsOnlineHTML() {
    let isOnlineHTML = document.getElementById('isOnline');
    isOnlineHTML.remove();
}

setTimeout(firstConnection, 0);
setInterval(testConnection, 5000);
