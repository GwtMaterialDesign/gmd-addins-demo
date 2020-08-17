var cacheName = 'cache_1597635091528';

var filesToCache = [  
'/gmd-addins-demo/snapshot/',

'GmdAddinsDemo/430945C9A23A2D097A691B173F10DE47.cache.js',

'GmdAddinsDemo/GmdAddinsDemo.devmode.js',

'GmdAddinsDemo/GmdAddinsDemo.nocache.js',

'GmdAddinsDemo/clear.cache.gif',

'GmdAddinsDemo/css/animation.css',

'GmdAddinsDemo/css/animation.min.css',

'GmdAddinsDemo/css/fontawesome-all.css',

'GmdAddinsDemo/css/fontawesome-all.min.css',

'GmdAddinsDemo/css/material-icons.css',

'GmdAddinsDemo/css/material-icons.min.css',

'GmdAddinsDemo/css/materialize.blue.css',

'GmdAddinsDemo/css/materialize.blue.min.css',

'GmdAddinsDemo/css/materialize.css',

'GmdAddinsDemo/css/materialize.min.css',

'GmdAddinsDemo/font/material-icons/MaterialIcons-Regular.eot',

'GmdAddinsDemo/font/material-icons/MaterialIcons-Regular.ttf',

'GmdAddinsDemo/font/material-icons/MaterialIcons-Regular.woff',

'GmdAddinsDemo/font/material-icons/MaterialIcons-Regular.woff2',

'GmdAddinsDemo/font/roboto/Roboto-Bold.ttf',

'GmdAddinsDemo/font/roboto/Roboto-Bold.woff',

'GmdAddinsDemo/font/roboto/Roboto-Bold.woff2',

'GmdAddinsDemo/font/roboto/Roboto-Light.ttf',

'GmdAddinsDemo/font/roboto/Roboto-Light.woff',

'GmdAddinsDemo/font/roboto/Roboto-Light.woff2',

'GmdAddinsDemo/font/roboto/Roboto-Medium.ttf',

'GmdAddinsDemo/font/roboto/Roboto-Medium.woff',

'GmdAddinsDemo/font/roboto/Roboto-Medium.woff2',

'GmdAddinsDemo/font/roboto/Roboto-Regular.ttf',

'GmdAddinsDemo/font/roboto/Roboto-Regular.woff',

'GmdAddinsDemo/font/roboto/Roboto-Regular.woff2',

'GmdAddinsDemo/font/roboto/Roboto-Thin.ttf',

'GmdAddinsDemo/font/roboto/Roboto-Thin.woff',

'GmdAddinsDemo/font/roboto/Roboto-Thin.woff2',

'GmdAddinsDemo/fontawesome-icons/fa-brands-400.eot',

'GmdAddinsDemo/fontawesome-icons/fa-brands-400.ttf',

'GmdAddinsDemo/fontawesome-icons/fa-brands-400.woff',

'GmdAddinsDemo/fontawesome-icons/fa-brands-400.woff2',

'GmdAddinsDemo/fontawesome-icons/fa-regular-400.eot',

'GmdAddinsDemo/fontawesome-icons/fa-regular-400.ttf',

'GmdAddinsDemo/fontawesome-icons/fa-regular-400.woff',

'GmdAddinsDemo/fontawesome-icons/fa-regular-400.woff2',

'GmdAddinsDemo/fontawesome-icons/fa-solid-900.eot',

'GmdAddinsDemo/fontawesome-icons/fa-solid-900.ttf',

'GmdAddinsDemo/fontawesome-icons/fa-solid-900.woff',

'GmdAddinsDemo/fontawesome-icons/fa-solid-900.woff2',

'index.html',

'launcher-icons/launcher1x.png',

'launcher-icons/launcher2x.png',

'launcher-icons/launcher4x.png',

'launcher-icons/launcher5x.png',

'splash/font/Roboto-Regular.eot',

'splash/font/Roboto-Regular.ttf',

'splash/font/Roboto-Regular.woff',

'splash/font/Roboto-Regular.woff2',

'splash/splash.css',

'splash/splash.js'
    ];


        /**
         * The install event is your chance to cache everything you need before being able to control clients. The promise you
         * pass to event.waitUntil() lets the browser know when your install completes, and if it was successful.
         */
        self.addEventListener('install', e => {
            e.waitUntil(
                caches.open(cacheName).then(cache => {
                    return cache.addAll(filesToCache)
                        .then(() => self.skipWaiting());
    })
    );
    });

        /**
         * Once your service worker is ready to control clients and handle functional events like push and sync, you'll get an
         * activate event. But that doesn't mean the page that called .register() will be controlled.
         */
        self.addEventListener('activate', event => {
            event.waitUntil(
                caches.keys().then(function(cacheNames) {
                    return Promise.all(
                        cacheNames.map(function(oldCache) {
                            if (oldCache !== cacheName) {
                                console.log('ServiceWorker : Deleting old cache:', oldCache);
                                return caches.delete(oldCache);
                            }
                        })
                    );
                }).then(function() {
                    console.log('ServiceWorker : Claiming clients for version', cacheName);
                    return self.clients.claim();
                })
            );
    });

        /**
         * It contains information about the fetch, including the request and how the receiver will treat the response.
         * It provides the event.respondWith() method, which allows us to provide a response to this fetch.
         */
        self.addEventListener('fetch', event => {
            if (event.request.method !== 'GET') {
            /* If we don't block the event as shown below, then the request will go to
               the network as usual.
            */
            return;
        }
        event.respondWith(
            caches.open(cacheName)
                .then(cache => cache.match(event.request, {ignoreSearch: true}))
            .then(response => {
            return response || fetch(event.request);
    })
    );
    });