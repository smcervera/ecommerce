
import {check, group} from "k6";
import http from "k6/http";

const host = __ENV.HOST || "localhost:5000";

export default function () {

    group("Ecommerce - GetPriceByBrandAndProductAndDate should return 200", function () {

        let cant = Math.floor(Math.random() * 3 + 1);
        let date = null;
        switch (cant) {
            case 2:
                date = '?date=2020-06-14T21:00:00';
                break;

            case 3:
                date = '?date=2020-06-15T10:00:00';
                break;

            default:
                date = '?date=2020-06-16T21:00:00';

        }

        let res = http.get(`http://${host}/brands/1/products/35455${date}`);

        check(res, {
            'is status 200': (r) => r.status === 200
        });

    });

    group("Ecommerce - GetPriceByBrandAndProductAndDate should return 404", function () {

        let res = http.get(`http://${host}/brands/1/products/35455?date=2019-06-14T10:00:00`);

        check(res, {
            'is status 404': (r) => r.status === 404
        });

    });

    group("Ecommerce - GetPriceByBrandAndProductAndDate should return 400", function () {

        let res = http.get(`http://${host}/brands/1/products/35455?date=20219-060:T100:00`);

        check(res, {
            'is status 400': (r) => r.status === 400
        });

    });
}

