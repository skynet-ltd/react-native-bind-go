package greeting

import (
	"encoding/json"
	"errors"
	"fmt"
	"io/ioutil"
	"net/http"
)

// Person ...
type Person struct {
	Name string
	Age  int
}

// English ...
func English(name string) string {
	return fmt.Sprintf("Hello ,%s\n", name)
}

// Stock ...
func Stock() string {
	resp, err := http.Get("https://api.coindesk.com/v1/bpi/currentprice.json")
	if err != nil {
		panic(err)
	}
	js, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		panic(err)
	}
	defer resp.Body.Close()

	res := map[string]interface{}{}

	err = json.Unmarshal(js, &res)
	if err != nil {
		panic(err)
	}
	bpi := res["bpi"]

	clearBpi, ok := bpi.(map[string]interface{})
	if !ok {
		panic(fmt.Errorf("can't type cast"))
	}

	usdRaw := clearBpi["USD"]

	clearUSD, ok := usdRaw.(map[string]interface{})
	if !ok {
		panic(fmt.Errorf("can't type cast"))
	}

	return fmt.Sprint(clearUSD["rate_float"])
}

// MustFail ...
func MustFail(f bool) (*Person, error) {
	if f {
		return nil, errors.New("super puper error")
	}
	return &Person{Name: "Deadpool", Age: 29}, nil
}
